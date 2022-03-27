package org.project.handlerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ResourceNotAvalaibleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
