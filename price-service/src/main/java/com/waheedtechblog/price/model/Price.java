/**
 * 
 */
package com.waheedtechblog.price.model;

import lombok.Data;

/**
 * @author Abdul
 *
 */
@Data
public class Price {

	private String id;
	private double amount;
	private Currency currency;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Price [id=" + id + ", amount=" + amount + ", currency=" + currency + "]";
	}
}
