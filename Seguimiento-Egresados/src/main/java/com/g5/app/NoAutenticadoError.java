package com.g5.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoAutenticadoError extends ResponseStatusException{

	
	private static final long serialVersionUID = 1L;

	public NoAutenticadoError() {
		super(HttpStatus.UNAUTHORIZED);
	}
	
}
