package com.npci.user_management_application.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {

Logger log = LoggerFactory.getLogger("CentralExceptionHandler.class");
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(InvalidEmailIdException.class)
	public String invalidEmailId(InvalidEmailIdException e) {
		log.error("Email Id is not in correct format.");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(InvalidPhoneNoException.class)
	public String invalidPhoneNo(InvalidPhoneNoException e) {
		log.error("Phone Number is not in correct format.");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ItemNotAvailableException.class)
	public String userNotAvailable(ItemNotAvailableException e) {
		log.error("User Details not Available.");
		return e.getMessage();
	}
}
