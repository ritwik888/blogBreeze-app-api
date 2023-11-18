package com.blogbreeze.app.api.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : %l, Stacktrace: %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
