/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.controller;

import ii.cipriantarlev.pointofsaleapi.model.RoleDto;
import ii.cipriantarlev.pointofsaleapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static ii.cipriantarlev.pointofsaleapi.utils.Constants.*;

@CrossOrigin(LOCAL_HOST)
@RestController
@RequestMapping(ROLES_ROOT_PATH)
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<RoleDto>> getRoles() {
		List<RoleDto> roles = roleService.findAll();
		return ResponseEntity.ok(roles);
	}
}