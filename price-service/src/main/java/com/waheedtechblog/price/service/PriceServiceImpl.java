/**
 * 
 */
package com.waheedtechblog.price.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.waheedtechblog.price.exception.PriceNotFoundException;
import com.waheedtechblog.price.model.Currency;
import com.waheedtechblog.price.model.Price;

/**
 * @author Abdul
 *
 */
@Repository
public class PriceServiceImpl implements PriceService {

	private static ConcurrentHashMap<String, Price> prices;

	static {
		prices = new ConcurrentHashMap<>();
		prices.putAll(initializePrice());
	}

	public Price getPrice(String id) {
		if (prices.containsKey(id)) {
			return prices.get(id);
		} else {
			throw new PriceNotFoundException("Id not found: " + id);
		}
	}

	@Override
	public Collection<Price> get() {
		System.out.println("Fetch all details....");
		return prices.values();
	}

	private static ConcurrentHashMap<String, Price> initializePrice() {
		ConcurrentHashMap<String, Price> prices = new ConcurrentHashMap<>();

		Price hpLaptop = new Price();
		hpLaptop.setId("1");
		hpLaptop.setProductId("1001");
		hpLaptop.setAmount(170000.00);
		hpLaptop.setCurrency(Currency.INR);

		Price s8PlusMobile = new Price();
		s8PlusMobile.setId("2");
		s8PlusMobile.setProductId("1002");
		s8PlusMobile.setAmount(70000.00);
		s8PlusMobile.setCurrency(Currency.INR);

		Price pulsarBike = new Price();
		pulsarBike.setId("3");
		pulsarBike.setProductId("1003");
		pulsarBike.setAmount(91000.00);
		pulsarBike.setCurrency(Currency.INR);

		prices.put("1", hpLaptop);
		prices.put("2", s8PlusMobile);
		prices.put("3", pulsarBike);

		return prices;
	}
}
