/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.service;

import ii.cipriantarlev.pointofsaleapi.model.RoleDto;

import java.util.List;

public interface RoleService {

	List<RoleDto> findAll();
}