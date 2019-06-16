/**
 * 
 */
package com.waheedtechblog.product.repository;

import com.waheedtechblog.product.model.Product;

/**
 * Handles the repo for Product.
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public interface ProductRepository {

	/**
	 * Returns the product detail from the DB or from remote service call.
	 * 
	 * @param id
	 *            id of the product
	 * @return Product Detail
	 */
	public Product getProduct(String id);
}
