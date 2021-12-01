package edu.najah.it.capp.exception;

public class timeoutConnection extends ProtocolException{

	public timeoutConnection(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "timeout Connection :: " + super.getMessage();
	}

}
