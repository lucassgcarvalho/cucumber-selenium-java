package com.stefanini.automation.rest;

import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stefanini.automation.infrastructure.config.PropertieConfig;
import com.stefanini.automation.infrastructure.helper.RestHelper;

public class ApiResource {
	
	private Properties properties = PropertieConfig.properties;

    public ResponseEntity<String> delete(String path, String object) {
        String resourceUrl = properties.getProperty("api.url");
        String fullUrl = resourceUrl.concat(path);
        
        RestTemplate restTemplate = RestHelper.getRestTemplate();
        HttpHeaders headers = RestHelper.getHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        return restTemplate.exchange(String.format(fullUrl, object), HttpMethod.DELETE, entity, String.class);
    }

}
