package edu.najah.it.capp.exception;

public class debugException extends ProtocolException{

	public debugException(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		return "wrong while debuging :: " + super.getMessage();
	}

}
