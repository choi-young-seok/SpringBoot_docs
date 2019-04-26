package kr.co.noel.study.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping(value = "/")
	public Map<String, Object> greeting() {
		
		return Collections.singletonMap("message", "Hello World");
	}
	
	@RequestMapping(value = "/test")
	public String testMapping() {
		
		return "hello world";
	}
}
