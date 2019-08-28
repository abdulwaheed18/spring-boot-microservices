/**
 * 
 */
package com.waheedtechblog.product.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.waheedtechblog.product.config.ProductFiegnClient;
import com.waheedtechblog.product.exception.ProductNotFoundException;
import com.waheedtechblog.product.model.Price;
import com.waheedtechblog.product.model.Product;
import com.waheedtechblog.product.repository.PriceCacheRepository;
import com.waheedtechblog.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author AbdulWaheed18@gmail.com
 *
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${price.service.url}")
	private String priceServiceUrl;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PriceCacheRepository priceCacheRepository;

	@Autowired
	private ProductFiegnClient productFiegnClient;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.waheedtechblog.product.service.ProductService#getProduct(java.lang.
	 * String)
	 */
	@HystrixCommand(fallbackMethod = "getProductDetailFromCache", ignoreExceptions = { ProductNotFoundException.class })
	@Override
	public Optional<Product> getProduct(String productId) {
		logger.info("Get Product detail for product id: {}", productId);
		Optional<Product> product = Optional.ofNullable(productRepository.getProduct(productId));
		product.orElseThrow(() -> new ProductNotFoundException("Product Id not Found: " + productId));
		ResponseEntity<Price> priceEntity = restTemplate.getForEntity(getPriceUrl(productId), Price.class);
		if (priceEntity.getStatusCode() == HttpStatus.OK) {
			Price price = priceEntity.getBody();
			product.get().setCurrency(price.getCurrency());
			product.get().setPrice(price.getAmount());
		}
		return product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.waheedtechblog.product.service.ProductService#getProductUsingFeignClient(
	 * java.lang.String)
	 */
	@Override
	public Optional<Product> getProductUsingFeignClient(String productId) {
		logger.info("Fiegn: Get Product detail for product id: {}", productId);
		Optional<Product> product = Optional.ofNullable(productRepository.getProduct(productId));
		product.orElseThrow(() -> new ProductNotFoundException("Product Id not Found: " + productId));
		Price price = productFiegnClient.getPrice(productId);
		if (price != null) {
			product.get().setCurrency(price.getCurrency());
			product.get().setPrice(price.getAmount());
		}
		return product;
	}

	Optional<Product> getProductDetailFromCache(String productId) {
		logger.info("Circuit Open, Getting Product detail from Cache for product id '{}'", productId);
		Optional<Product> product = Optional.ofNullable(productRepository.getProduct(productId));
		product.orElseThrow(() -> new ProductNotFoundException("Product Id not Found: " + productId));
		Price price = getPrice(productId);
		product.get().setCurrency(price.getCurrency());
		product.get().setPrice(price.getAmount());
		return product;
	}

	private Price getPrice(String id) {
		return priceCacheRepository.getPrice(id);
	}

	private String getPriceUrl(String priceId) {
		// return "http://" + priceServiceUrl + "prices/" + priceId;
		return "http://price-service/prices/" + priceId;
	}

}
