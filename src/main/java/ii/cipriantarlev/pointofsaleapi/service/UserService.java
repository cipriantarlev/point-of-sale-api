/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.service;

import ii.cipriantarlev.pointofsaleapi.model.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

	List<UserDto> findAll();

	UserDto findById(UUID id);

	UserDto findByUsername(String username);

	UserDto save(UserDto userDto);

	UserDto update(UserDto userDto);

	void deleteById(UUID id);
}