/**
 * 
 */
package com.waheedtechblog.product.service;

import java.util.Optional;

import com.waheedtechblog.product.model.Product;

/**
 * Service layer for Product
 * 
 * @author AbdulWaheed18@gmail.com
 *
 */
public interface ProductService {

	/**
	 * Returns the product details
	 * 
	 * @param productId
	 *            unique id of the product
	 * @return Product Detail
	 */
	public Optional<Product> getProduct(String productId);
	
	public Optional<Product> getProductUsingFeignClient(String productId);

}
