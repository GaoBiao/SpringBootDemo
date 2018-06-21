package com.hebgb.demo.exception;

public class MessageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	public MessageException() {

	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(String message, String code) {
		super(message);
		this.code = code;
	}

	public MessageException(String message, Throwable e) {
		super(message, e);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
