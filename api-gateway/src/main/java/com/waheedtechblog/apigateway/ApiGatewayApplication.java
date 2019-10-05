package com.waheedtechblog.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.waheedtechblog.apigateway.filters.ErrorFilter;
import com.waheedtechblog.apigateway.filters.PostFilter;
import com.waheedtechblog.apigateway.filters.PreFilter;
import com.waheedtechblog.apigateway.filters.RouteFilter;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return ALWAYS_SAMPLE;
	}

	private static final Sampler ALWAYS_SAMPLE = new Sampler() {
		@Override
		public boolean isSampled(long traceId) {
			return true;
		}

		@Override
		public String toString() {
			return "AlwaysSample";
		}
	};

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
