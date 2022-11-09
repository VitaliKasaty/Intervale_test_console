package com.vitalikasaty.intervale.test.library.dao;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException() {
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

}
