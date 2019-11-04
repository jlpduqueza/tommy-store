package com.tommystore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value=Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		
		return "error";
	}
	
}
