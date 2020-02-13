package com.stefanini.automation.rest.functionality;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.ApiResource;

public class FunctionalityApiResource {
	
	private String pathRoleUrl = "functionality/%s";

    public ResponseEntity<String> deleteFunctionality(String functionality) {
    	 return new ApiResource().delete(getPathRoleUrl(), functionality);
    }

	public String getPathRoleUrl() {
		return pathRoleUrl;
	}
    
    
}
