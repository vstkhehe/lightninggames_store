package com.flashgames.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException {
	
	private static final long serialVersionUID = 1L;
	
	public FileNotFoundException(String message) {
		super();
	}
	
	public FileNotFoundException(String message, Throwable cause) {
		super();
	}
	
}
