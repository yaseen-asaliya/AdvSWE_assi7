package edu.najah.it.capp.exception;

public class warningException extends ProtocolException{

	public warningException(String message) {
		super(message);
	}
	
	
	@Override
	public String getMessage() {
		return "there is a warning :: " + super.getMessage();
	}


}
