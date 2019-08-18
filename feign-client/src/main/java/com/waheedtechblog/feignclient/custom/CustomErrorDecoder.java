package com.waheedtechblog.feignclient.custom;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String message, Response response) {

		switch (response.status()) {
		case 400:
			// throw custom Exception
			return new Exception("BAD REQUEST");
		case 404:
			return new Exception("NOT FOUND");
		default:
			return new Exception("Generic error");
		}
	}
}