/*******************************************************************************
 * © 2023 II Ciprian Tarlev. All Rights Reserved.
 *******************************************************************************/
package ii.cipriantarlev.pointofsaleapi.exceptions;

import java.io.Serial;
import java.util.UUID;

/**
 * Exception to be thrown when the DTO is not found with given id.
 * 
 * @author ciprian.tarlev
 */
public class DTONotFoundException extends RuntimeException {
	private final UUID uuidId;

	@Serial
	private static final long serialVersionUID = -5344786827355057523L;

	public DTONotFoundException(String message, UUID id) {
		super(message);
		this.uuidId = id;
	}

	public DTONotFoundException(String message) {
		super(message);
		this.uuidId = UUID.randomUUID();
	}

	public UUID getId() {
		return uuidId;
	}
}