/**
 * 
 */
package fr.diginamic.GP3Covoiturage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author antPinot
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	/** serialVersionUID */

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * 
	 * @param message
	 */
	public EntityNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
