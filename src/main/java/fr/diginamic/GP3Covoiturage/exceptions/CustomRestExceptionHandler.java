/**
 * 
 */
package fr.diginamic.GP3Covoiturage.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Controller advice permettant de gérer les exceptions générées pas Spring Boot
 * de type MethodArgumentNotValidException en cas de problème de validation
 * 
 * @author antPinot
 *
 */

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> errors = new ArrayList<>();

		ex.getBindingResult().getFieldErrors().forEach(e -> errors.add(e.getField() + ": " + e.getDefaultMessage()));
		ex.getBindingResult().getGlobalErrors()
				.forEach(e -> errors.add(e.getObjectName() + ": " + e.getDefaultMessage()));

		ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

		return handleExceptionInternal(ex, validationError, headers, validationError.getStatus(), request);

	}
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex){
		return new ResponseEntity<Object>("L'entité n'existe pas", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestException(BadRequestException ex){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response){
		if (ex instanceof NullPointerException) {
			return new ResponseEntity<Object>("Un des champs est null", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>("Erreur interne du serveur", HttpStatus.BAD_REQUEST);
	}
	

}
