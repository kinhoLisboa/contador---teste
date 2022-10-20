package br.com.microservice.cliente.handle.exception;

public class clientNotFoudException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public clientNotFoudException (String message) {
		super(message);
	}

}
