package com.zurita.empleados.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralEmpleadoException extends RuntimeException{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public GeneralEmpleadoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneralEmpleadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GeneralEmpleadoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneralEmpleadoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GeneralEmpleadoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
