package org.project.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LENGTH_REQUIRED)
public class QuotaExceetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
