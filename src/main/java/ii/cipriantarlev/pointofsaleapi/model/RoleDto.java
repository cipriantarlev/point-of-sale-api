/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class RoleDto {
	@NotNull
	private UUID id;
	@NotBlank(message = "Role name should not be blank or null")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Role name should contain only letters, numbers and underline")
	@Size(min = 1, max = 50, message = "Role name length should be between {min} and {max}")
	private String role;
}