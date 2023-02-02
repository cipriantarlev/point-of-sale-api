/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.modelmapper;

import ii.cipriantarlev.pointofsaleapi.model.RoleDto;
import ii.cipriantarlev.pointofsaleapi.repository.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

	@Autowired
	private ModelMapper modelMapper;

	public RoleDto mapRoleToRoleDto(Role role) {
		return modelMapper.map(role, RoleDto.class);
	}

	public Role mapRoleDtoToRole(RoleDto role) {
		return modelMapper.map(role, Role.class);
	}
}
