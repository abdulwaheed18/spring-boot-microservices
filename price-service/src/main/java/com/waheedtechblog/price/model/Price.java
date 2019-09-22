/**
 * 
 */
package com.waheedtechblog.price.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author Abdul
 *
 */
@Data
public class Price {

	private String id;
	
	@JsonIgnore
	private String productId;
	private double amount;
	private Currency currency;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", productId=" + productId + ", amount=" + amount + ", currency=" + currency + "]";
	}

}
