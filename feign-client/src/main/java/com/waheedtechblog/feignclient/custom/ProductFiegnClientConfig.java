package com.waheedtechblog.feignclient.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.codec.ErrorDecoder;
import okhttp3.OkHttpClient;

@Configuration
public class ProductFiegnClientConfig {

	@Bean
	public OkHttpClient client() {
		return new OkHttpClient();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}

}
