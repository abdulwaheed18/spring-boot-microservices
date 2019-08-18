package com.waheedtechblog.feignclient.custom;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waheedtechblog.feignclient.model.Product;

@FeignClient(name = "product-service", configuration = ProductFiegnClientConfig.class) // app-name of Product register
																						// on Discovery Server
public interface ProductFiegnClient {

	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}", consumes = "application/json")
	// shorthand
	// @RequestMapping("/products/{id}")
	public Product get(@PathVariable(value = "id") Long id);

}
