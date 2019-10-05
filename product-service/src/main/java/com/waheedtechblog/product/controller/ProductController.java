package com.waheedtechblog.product.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waheedtechblog.product.model.Product;
import com.waheedtechblog.product.service.ProductService;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private Tracer tracer;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable String id) {
		logger.debug("Notification: Request Received for Product Id: {}", id);
		// TraceId can be added in error respose for easy debugging
		logger.info("Tracer Id: '{}'", tracer.currentSpan().context().traceIdString());
		return ResponseEntity.of(productService.getProduct(id));
	}

}
