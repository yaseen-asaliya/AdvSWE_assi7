package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.NoConnection;
import edu.najah.it.capp.exception.ProtocolException;

public class Telnet implements Protocol {

private static Protocol instance;
	
	
	private Telnet() {
		System.out.println("Creating a new Telnet insatnce");
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Telnet();
		}
		return instance;
	}
	@Override
	public boolean release() {
		instance = null;
		return true;
	}

	@Override
	public void send(String message) throws ProtocolException {
		if(instance!=null)
			System.out.println("Sending message from TELNET :: " + message);
		throw new NoConnection("Telent");
	}

}
