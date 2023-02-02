/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.model;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class UserDto {

	@NotNull
	private UUID id;

	@NotBlank(message = "Username should not be blank or null")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username should contain only letters and numbers")
	@Size(min = 1, max = 100, message = "Username length should be between {min} and {max}")
	private String username;

	@NotBlank(message = "Password should not be blank or null")
	@Size(min = 1, max = 100, message = "Password length should be between {min} and {max}")
	private String password;

	@NotBlank(message = "Email should not be blank or null")
	@Email(message = "Email should be valid")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email should respect the patter: email@email.com")
	@Size(min = 5, max = 100, message = "Email length should be between {min} and {max}")
	private String email;

	@Valid
	@NotNull(message = "Roles should not be null")
	private List<RoleDto> roles;
}