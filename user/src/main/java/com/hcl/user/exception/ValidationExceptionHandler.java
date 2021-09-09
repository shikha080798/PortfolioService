package com.hcl.user.exception;

public class ValidationExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ValidationExceptionHandler(String msg) {
		super();
		this.msg = msg;
	}

	
	
	
	
	

}
