package com.stefanini.automation.rest.account;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.ApiResource;

public class AccountApiResource {
	
	private String pathRoleUrl = "account/%s";

    public ResponseEntity<String> deleteAccount(String id) {
    	 return new ApiResource().delete(getPathRoleUrl(), id);
    }

	public String getPathRoleUrl() {
		return pathRoleUrl;
	}
    
    
}
