/**
 * 
 */
package com.waheedtechblog.price.controller;

import java.util.Collection;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waheedtechblog.price.model.Price;
import com.waheedtechblog.price.service.PriceService;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
@RestController
@RequestMapping("prices")
public class PriceController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PriceController.class);

	@Autowired
	private PriceService priceService;

	@GetMapping("/{id}")
	public ResponseEntity<Price> getPrice(@PathVariable String id) {
		logger.info("Notification: Request Received for Price Id: {}", id);
		return ResponseEntity.ok(priceService.getPrice(id));
	}

	@GetMapping()
	public ResponseEntity<Collection<Price>> get() {
		return ResponseEntity.ok(priceService.get());
	}

}
