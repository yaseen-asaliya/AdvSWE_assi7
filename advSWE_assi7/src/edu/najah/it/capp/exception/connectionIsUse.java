package edu.najah.it.capp.exception;

public class connectionIsUse extends ProtocolException{

	public connectionIsUse(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "connection is use  :: " + super.getMessage();
	}


}
