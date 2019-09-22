package com.waheedtechblog.apigateway.filters;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

	@Value("${admin.username}")
	private String username;

	@Value("${admin.password}")
	private char[] password;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {

		final RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletResponse response = requestContext.getResponse();
		logger.info("in zuul filter " + requestContext.getRequest().getRequestURI());
		try {
			final String authorization = requestContext.getRequest().getHeader("Authorization");
			if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
				// Authorization: Basic base64credentials
				String base64Credentials = authorization.substring("Basic".length()).trim();
				byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
				String credentials = new String(credDecoded, StandardCharsets.UTF_8);
				// credentials = username:password
				final String[] values = credentials.split(":", 2);
				if (values[0].equals(username) && values[1].equals(new String(password))) {
				} else {
					requestContext.unset();
					response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid Credential");
				}
			}
		} catch (Exception ex) {

		}

		return null;
	}
}