/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import ii.cipriantarlev.pointofsaleapi.model.RoleDto;
import ii.cipriantarlev.pointofsaleapi.model.UserDto;
import ii.cipriantarlev.pointofsaleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService {
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = userService.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + "was not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(mapRoleDTOToStringArray(user.getRoles())));
	}

	private String[] mapRoleDTOToStringArray(List<RoleDto> roles) {
		List<String> roleList = roles.stream()
									 .map(RoleDto::getRole)
									 .collect(Collectors.toList());

		return roleList.toArray(new String[0]);
	}
}