package edu.najah.it.capp.exception;

public class errorException extends ProtocolException{

	public errorException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "there is an Error :: " + super.getMessage();
	}


}
