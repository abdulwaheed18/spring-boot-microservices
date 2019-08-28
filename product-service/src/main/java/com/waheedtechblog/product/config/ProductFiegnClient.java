/**
 * 
 */
package com.waheedtechblog.product.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waheedtechblog.product.model.Price;

/**
 * @author Abdul
 *
 */
@FeignClient(name = "price-service")

// Load balance will fetch the list of Server running for price-service and will
// get the hostname and URL of prices-service
@RibbonClient(name = "price-service")
public interface ProductFiegnClient {

	@RequestMapping("/prices/{id}")
	public Price getPrice(@PathVariable(value = "id") String id);

}
