/**
 * 
 */
package com.waheedtechblog.product.repository;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.waheedtechblog.product.model.Currency;
import com.waheedtechblog.product.model.Price;

/**
 * @author AbdulWaheed
 *
 */
@Repository
public class PriceCacheRepositoryImpl implements PriceCacheRepository {

	private static ConcurrentHashMap<String, Price> prices;

	static {
		prices = new ConcurrentHashMap<>();
		prices.putAll(initializePrice());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.waheedtechblog.product.repository.PriceCacheRepository#getPrice(java.lang
	 * .String)
	 */
	@Override
	public Price getPrice(String id) {
		if (prices.containsKey(id)) {
			return prices.get(id);
		} else {
			return null;
		}
	}

	private static ConcurrentHashMap<String, Price> initializePrice() {
		ConcurrentHashMap<String, Price> prices = new ConcurrentHashMap<>();

		Price hpLaptop = new Price();
		hpLaptop.setId("1");
		hpLaptop.setAmount(170000.00);
		hpLaptop.setCurrency(Currency.INR);

		Price s8PlusMobile = new Price();
		s8PlusMobile.setId("2");
		s8PlusMobile.setAmount(70000.00);
		s8PlusMobile.setCurrency(Currency.INR);

		Price pulsarBike = new Price();
		pulsarBike.setId("3");
		pulsarBike.setAmount(91000.00);
		pulsarBike.setCurrency(Currency.INR);

		prices.put("1", hpLaptop);
		prices.put("2", s8PlusMobile);
		prices.put("3", pulsarBike);

		return prices;
	}

}
