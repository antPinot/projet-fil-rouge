/**
 * 
 */
package fr.diginamic.GP3Covoiturage.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author antPinot
 *
 */
public class ValidationError {
	
	private HttpStatus status;

	private String message;

	private List<String> errors;

	/**
	 * Constructeur
	 * 
	 * @param status
	 * @param message
	 * @param errors
	 */
	public ValidationError(HttpStatus status, String message, List<String> errors) {
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	/**
	 * Getter pour l'attribut status
	 * 
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * Setter pour l'attribut status
	 * 
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * Getter pour l'attribut message
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter pour l'attribut message
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter pour l'attribut errors
	 * 
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Setter pour l'attribut errors
	 * 
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
