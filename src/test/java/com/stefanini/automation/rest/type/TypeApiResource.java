package com.stefanini.automation.rest.type;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.ApiResource;

public class TypeApiResource {
	
	private String pathRoleUrl = "type/%s";

    public ResponseEntity<String> deleteType(String functionality) {
    	 return new ApiResource().delete(getPathRoleUrl(), functionality);
    }

	public String getPathRoleUrl() {
		return pathRoleUrl;
	}
    
    
}
