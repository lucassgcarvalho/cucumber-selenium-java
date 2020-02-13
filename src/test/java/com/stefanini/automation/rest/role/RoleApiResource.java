package com.stefanini.automation.rest.role;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.ApiResource;

public class RoleApiResource {
	
	private String pathRoleUrl = "role/%s";

    public ResponseEntity<String> deleteRole(String role) {
        return new ApiResource().delete(getPathRoleUrl(), role);
    }

	public String getPathRoleUrl() {
		return pathRoleUrl;
	}
    
    
}
