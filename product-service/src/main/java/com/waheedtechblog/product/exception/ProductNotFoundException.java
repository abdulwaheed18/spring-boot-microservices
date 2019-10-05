/**
 * 
 */
package com.waheedtechblog.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -234662522339292486L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
