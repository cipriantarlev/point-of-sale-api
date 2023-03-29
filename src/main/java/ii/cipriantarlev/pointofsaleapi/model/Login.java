/*
 * ******************************************************************************
 *  © 2023 II Ciprian Tarlev. All Rights Reserved.
 * ******************************************************************************
 */
package ii.cipriantarlev.pointofsaleapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {
	private String timestamp;
	private Integer status;
	private String message;
	private String path;
}