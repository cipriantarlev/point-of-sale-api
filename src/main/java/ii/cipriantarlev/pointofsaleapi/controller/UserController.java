/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import ii.cipriantarlev.pointofsaleapi.model.UserDto;
import ii.cipriantarlev.pointofsaleapi.service.UserService;
import ii.cipriantarlev.pointofsaleapi.utils.RestControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ii.cipriantarlev.pointofsaleapi.utils.Constants.*;

@CrossOrigin(LOCAL_HOST)
@RestController
@RequestMapping(USERS_ROOT_PATH)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestControllerUtil restControllerUtil;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userService.findAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping(ID_PATH)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
		var user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		var savedUser = userService.save(userDto);
		var headers = restControllerUtil.setHttpsHeaderLocation(USERS_ROOT_PATH.concat(ID_PATH),
				savedUser.getId());
		return new ResponseEntity<>(savedUser, headers, HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
		var savedUser = userService.update(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

	@DeleteMapping(ID_PATH)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}