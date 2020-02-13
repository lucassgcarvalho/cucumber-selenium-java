package com.stefanini.automation.rest.correlation;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.ApiResource;

public class CorrelationApiResource {
	
	private String pathRoleUrl = "correlation/%s";

    public ResponseEntity<String> deleteCorrelation(String id) {
    	 return new ApiResource().delete(getPathRoleUrl(), id);
    }

	public String getPathRoleUrl() {
		return pathRoleUrl;
	}
    
    
}
