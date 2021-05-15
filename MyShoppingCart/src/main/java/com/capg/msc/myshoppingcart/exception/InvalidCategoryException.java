package com.capg.msc.myshoppingcart.exception;

public class InvalidCategoryException extends Exception {
    private String category;

    
	public InvalidCategoryException() {
		super();
	}


	public InvalidCategoryException(String category) {
		super();
		this.category = category;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
    
	public InvalidCategoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
