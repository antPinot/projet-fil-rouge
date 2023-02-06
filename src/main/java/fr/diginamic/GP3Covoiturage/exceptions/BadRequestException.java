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

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;

	/**Constructeur
	 * @param message
	 */
	public BadRequestException(String message) {
		super(message);
		
	}

}
