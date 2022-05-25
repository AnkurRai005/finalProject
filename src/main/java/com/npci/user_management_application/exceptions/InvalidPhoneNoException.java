package com.npci.user_management_application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvalidPhoneNoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7062575436190799100L;
	final String message;
}
