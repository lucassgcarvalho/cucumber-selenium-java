package com.stefanini.automation.rest.user;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.ApiResource;

public class UserApiResource {
	
	private String pathRoleUrl = "user/%s";

    public ResponseEntity<String> deleteUser(String functionality) {
    	 return new ApiResource().delete(getPathRoleUrl(), functionality);
    }

	public String getPathRoleUrl() {
		return pathRoleUrl;
	}
    
    
}
