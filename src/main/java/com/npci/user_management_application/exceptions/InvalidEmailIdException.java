package com.npci.user_management_application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvalidEmailIdException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1418765542614046837L;
	final String message;
}
