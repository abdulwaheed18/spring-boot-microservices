package com.waheedtechblog.price.service;

import com.waheedtechblog.price.model.Price;

/**
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public interface PriceService {

	/**
	 * Return the price of the product
	 * 
	 * @param id
	 *            id of the product
	 * @return price detail
	 */
	public Price getPrice(String id);
}
