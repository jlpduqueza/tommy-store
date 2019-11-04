package com.tommystore.controller.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/example")
public class ExampleController {

	@RequestMapping(value="test")
	public String list() {
		
		return "example";
	}
	
}
