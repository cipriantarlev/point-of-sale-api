/*******************************************************************************
 * © 2021 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.controller;

import java.time.LocalDateTime;

import ii.cipriantarlev.pointofsaleapi.model.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static ii.cipriantarlev.pointofsaleapi.utils.Constants.LOCAL_HOST;

@CrossOrigin(LOCAL_HOST)
@RestController
public class LoginController {

	@GetMapping("/login")
	public ResponseEntity<Login> login() {
		var login = new Login();
		login.setTimestamp(LocalDateTime.now().toString());
		login.setMessage("Successfully authenticated");
		login.setStatus(HttpStatus.OK.value());
		login.setPath("/api/login");
		return ResponseEntity.ok(login);
	}
}
