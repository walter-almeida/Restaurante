package edu.infnet.al.restaurante.exception;

public class DAOException extends Exception {

	public DAOException(String msg, Exception e) {
		super(msg +"\n"+ e);
	}
	
	

}
