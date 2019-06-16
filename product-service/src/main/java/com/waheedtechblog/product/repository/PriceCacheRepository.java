/**
 * 
 */
package com.waheedtechblog.product.repository;

import com.waheedtechblog.product.model.Price;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
public interface PriceCacheRepository {

	public Price getPrice(String id);
}
