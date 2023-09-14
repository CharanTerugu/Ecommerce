package com.spring.product.exceptions;

public class OutOfStock extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OutOfStock(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OutOfStock(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OutOfStock(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OutOfStock(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
