package com.waheedtechblog.feignclient.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waheedtechblog.feignclient.custom.ProductFiegnClient;
import com.waheedtechblog.feignclient.model.Product;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("feign")
public class FeignClientController {
	
	@Autowired
	public ProductFiegnClient productFiegnClient;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FeignClientController.class);

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		logger.debug("Notification: Request Received for Product Id: {}", id);
		return ResponseEntity.ok(productFiegnClient.get(id));
	}

}
