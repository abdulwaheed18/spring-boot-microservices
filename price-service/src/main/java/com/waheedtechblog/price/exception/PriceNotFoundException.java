package com.waheedtechblog.price.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8322943359320444824L;

	public PriceNotFoundException(String message) {
		super(message);
	}

}
