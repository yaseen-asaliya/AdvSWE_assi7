package edu.najah.it.capp.exception;

public class NoConnection extends ProtocolException{

	public NoConnection(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "No Connection :: " + super.getMessage();
	}

}
