/**
 * 
 */
package com.waheedtechblog.product.model;

import lombok.Data;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
@Data
public class Product {

	private String prductId;
	private String name;
	private String description;
	private double price;
	private Currency currency;

	public String getPrductId() {
		return prductId;
	}

	public void setPrductId(String prductId) {
		this.prductId = prductId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Product [prductId=" + prductId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", currency=" + currency + "]";
	}
}


