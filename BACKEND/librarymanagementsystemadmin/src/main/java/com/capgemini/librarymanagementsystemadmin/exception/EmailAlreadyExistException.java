package com.capgemini.librarymanagementsystemadmin.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExistException extends RuntimeException {
	public EmailAlreadyExistException(String msg) {
		super(msg);
	}
}
