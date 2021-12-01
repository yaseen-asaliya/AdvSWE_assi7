package edu.najah.it.capp.exception;

public class infoException extends ProtocolException{

	public infoException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "wrong while getting info :: " + super.getMessage();
	}

}
