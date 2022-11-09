package com.vitalikasaty.intervale.test.library.service;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
