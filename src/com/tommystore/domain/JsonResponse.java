package com.tommystore.domain;

import java.util.Map;

public class JsonResponse<T> {

	private T data;
	private boolean validated;
	private String location;
	private Map<String, String> errorMessages;
	private String customMessage;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public String getCustomMessage() {
		return customMessage;
	}
	
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public boolean isValidated() {
		return validated;
	}
	
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
