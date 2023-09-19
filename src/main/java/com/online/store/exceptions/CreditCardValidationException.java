package com.online.store.exceptions;

public class CreditCardValidationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreditCardValidationException(String message) {
        super(message);
    }
}