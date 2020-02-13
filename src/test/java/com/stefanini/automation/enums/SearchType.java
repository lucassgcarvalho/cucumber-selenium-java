package com.stefanini.automation.enums;

public enum SearchType {
	
	CPF("CPF"),
	EMAIL("E-mail"),
	NOME("Nome");
	
	private String description;
	
	SearchType(String description) {
		 this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static SearchType findType(String type) {
		if(type !=null) {
			for (SearchType element : SearchType.values()) {
				if(element.getDescription().equalsIgnoreCase(type)) {
					return element;
				}
			}
		}
		return null;
	}
	
	
}

