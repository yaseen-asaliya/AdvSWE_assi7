package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.NoConnection;
import edu.najah.it.capp.exception.ProtocolException;

public class Ftp implements Protocol {
	
	private static Protocol instance;
	
	
	private Ftp() {
		System.out.println("Creating a new FTP insatnce");
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Ftp();
		}
		return instance;
	}
	@Override
	public boolean release() {
		instance = null;
		return true;
	}

	@Override
	public void send(String message) throws ProtocolException{
		if(instance!=null)
			System.out.println("Sending message from Ftp :: " + message);
		throw new NoConnection("Ftp");

	}

}
