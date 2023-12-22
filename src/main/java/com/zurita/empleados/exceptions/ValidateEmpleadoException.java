package com.zurita.empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)

public class ValidateEmpleadoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidateEmpleadoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidateEmpleadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValidateEmpleadoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValidateEmpleadoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValidateEmpleadoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}





