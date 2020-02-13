package com.stefanini.automation.enums;

public enum Status {
	
	INACTIVE("Inativo", false),
	ACTIVE("Ativo", true);
	
	private String description;
	private Boolean status;
	
	Status(String description, Boolean status) {
		 this.description = description;
		 this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public static Status findType(String type) {
		if(type !=null) {
			for (Status element : Status.values()) {
				if(element.getDescription().equalsIgnoreCase(type)) {
					return element;
				}
			}
		}
		return null;
	}
	
	public static Status findType(boolean type) {
		if(type) {
			for (Status element : Status.values()) {
				if( element.getStatus() ==  new Boolean(type).booleanValue()) {
					return element;
				}
			}
		}
		return null;
	}
	
}

