/**
 * 
 */
package com.waheedtechblog.product.repository;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.waheedtechblog.product.model.Product;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private static ConcurrentHashMap<String, Product> products;

	static {
		products = new ConcurrentHashMap<>();
		products.putAll(initializeProduct());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.waheedtechblog.product.repository.ProductRepository#getProduct(java.lang.
	 * String)
	 */
	@Override
	public Product getProduct(String id) {
		if (products.containsKey(id)) {
			return products.get(id);
		} else {
			return null;
		}
	}

	private static ConcurrentHashMap<String, Product> initializeProduct() {
		ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();

		Product hpLaptop = new Product();
		hpLaptop.setPrductId("1");
		hpLaptop.setName("HP Laptop");
		hpLaptop.setDescription("Dell Xps 15 inches laptop");

		Product s8PlusMobile = new Product();
		s8PlusMobile.setPrductId("2");
		s8PlusMobile.setName("S8 Plus");
		s8PlusMobile.setDescription("Samsung Galaxy S8 plus mobile");

		Product pulsarBike = new Product();
		pulsarBike.setPrductId("3");
		pulsarBike.setName("Plusar 220");
		pulsarBike.setDescription("Bajaj pulsar 220 Bike");

		products.put("1", hpLaptop);
		products.put("2", s8PlusMobile);
		products.put("3", pulsarBike);

		return products;

	}

}
