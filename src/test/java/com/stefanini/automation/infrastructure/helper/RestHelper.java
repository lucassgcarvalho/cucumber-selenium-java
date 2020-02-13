package com.stefanini.automation.infrastructure.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestHelper {

	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public static RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.setErrorHandler(new ErrorHandler());
		return restTemplate;
	}
}
