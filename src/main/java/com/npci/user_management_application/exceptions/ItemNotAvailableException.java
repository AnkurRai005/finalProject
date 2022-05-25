package com.npci.user_management_application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ItemNotAvailableException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7110297030812680145L;
	final String message;
}
