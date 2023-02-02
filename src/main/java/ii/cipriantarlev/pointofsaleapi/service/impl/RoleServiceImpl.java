/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import ii.cipriantarlev.pointofsaleapi.model.RoleDto;
import ii.cipriantarlev.pointofsaleapi.modelmapper.RoleMapper;
import ii.cipriantarlev.pointofsaleapi.repository.RoleRepository;
import ii.cipriantarlev.pointofsaleapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<RoleDto> findAll() {
		return roleRepository.findAll()
							 .stream()
							 .map(role -> roleMapper.mapRoleToRoleDto(role))
							 .collect(Collectors.toList());
	}
}