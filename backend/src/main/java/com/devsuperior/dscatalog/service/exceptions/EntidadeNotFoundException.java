package com.devsuperior.dscatalog.service.exceptions;

public class EntidadeNotFoundException extends RuntimeException{
	
	private static final long serialVersioUID = 1L;

	public EntidadeNotFoundException(String message) {
		super(message);
	}
}
