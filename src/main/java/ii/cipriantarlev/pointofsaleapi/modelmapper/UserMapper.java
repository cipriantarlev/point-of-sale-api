/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.modelmapper;

import ii.cipriantarlev.pointofsaleapi.model.UserDto;
import ii.cipriantarlev.pointofsaleapi.repository.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	@Autowired
	private ModelMapper modelMapper;
	public UserDto mapEntityToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}
	public User mapEntityDto(UserDto user) {
		return modelMapper.map(user, User.class);
	}
}