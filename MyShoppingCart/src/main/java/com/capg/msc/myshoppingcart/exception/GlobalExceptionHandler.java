package com.capg.msc.myshoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> invalidcostinputByUser(InvalidCostRangeException ex){
		int range1 = ex.getRange1();
		int range2 = ex.getRange2();
		
		// design custom exception response 
		
		CustomExceptionResponse excResponse = new CustomExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Cost Range "+range1+". Please try again with a higher range");
		
		
		return new ResponseEntity<CustomExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler
	public ResponseEntity<CustomExceptionResponse> invalidProductId(java.util.NoSuchElementException ex)
	{
		
		
		// design custom exception response 
		
		CustomExceptionResponse excResponse = new CustomExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Product Id. Please try again");
		
		
		return new ResponseEntity<CustomExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> invalidcategorybyUser(InvalidCategoryException ex){
		String category = ex.getCategory();
		
		// design custom exception response 
		
		CustomExceptionResponse excResponse = new CustomExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Category :"+category+". Please try again");
		
		
		return new ResponseEntity<CustomExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
    }
	
}
