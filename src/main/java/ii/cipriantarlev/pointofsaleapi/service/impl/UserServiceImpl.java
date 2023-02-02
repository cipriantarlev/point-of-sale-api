/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import ii.cipriantarlev.pointofsaleapi.exceptions.DTOFoundWhenSaveException;
import ii.cipriantarlev.pointofsaleapi.exceptions.DTONotFoundException;
import ii.cipriantarlev.pointofsaleapi.model.UserDto;
import ii.cipriantarlev.pointofsaleapi.modelmapper.UserMapper;
import ii.cipriantarlev.pointofsaleapi.repository.UserRepository;
import ii.cipriantarlev.pointofsaleapi.repository.entity.User;
import ii.cipriantarlev.pointofsaleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

//	@Autowired
//	private EntitiesHistoryService entitiesHistoryService;

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream().map(this::hideUserPassword)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto findById(UUID id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return hideUserPassword(user.get());
		}

		throw new DTONotFoundException(String.format("User with %s not found", id), id);
	}

	@Override
	public UserDto save(UserDto userDto) {
		if (userDto.getId() != null && userRepository.findById(userDto.getId()).isPresent()) {
			throw new DTOFoundWhenSaveException(
					String.format("User with id: '%s' already exists in database. "
							+ "Please use update in order to save the changes in database", userDto.getId()),
					userDto.getId());
		}

		var user = userRepository.save(userMapper.mapEntityDto(userDto));
//		entitiesHistoryService.createEntityHistoryRecord(user, null, HistoryAction.CREATE);
		return userMapper.mapEntityToDto(user);
	}

	@Override
	public UserDto update(UserDto userDto) {
		var foundUser = userMapper.mapEntityDto(this.findById(userDto.getId()));
		if (userDto.getUsername() != null && userRepository.findByUsername(userDto.getUsername()) != null
				&& !userDto.getUsername().equalsIgnoreCase(foundUser.getUsername())) {

			throw new DTOFoundWhenSaveException(
					String.format("User with username %s already exists in database.", userDto.getUsername()));
		}
		var user = userRepository.save(userMapper.mapEntityDto(userDto));
//		entitiesHistoryService.createEntityHistoryRecord(user, foundUser, HistoryAction.UPDATE);
		return userMapper.mapEntityToDto(user);
	}

	@Override
	public void deleteById(UUID id) {
//		entitiesHistoryService.createEntityHistoryRecord(userMapper.mapUserDtoToUser(this.findById(id)), null, HistoryAction.DELETE);
		userRepository.deleteById(id);
	}

	@Override
	public UserDto findByUsername(String username) {
		var user = userRepository.findByUsername(username);

		if (user != null) {
			return userMapper.mapEntityToDto(user);
		}

		throw new DTONotFoundException(String.format("User with username %s not found", username));
	}

	private UserDto hideUserPassword(User user) {
		user.setPassword("");
		return userMapper.mapEntityToDto(user);
	}
}