package com.gn.restsvc.GnRestSvc.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello api is invoked");
		return "Hello";
	}
	
	@GetMapping("/hello-bean")
	public HelloBean helloBean() {
		System.out.println("hello api is invoked");
		return new HelloBean("HelloBean");
	}
	
	@GetMapping("/hello-bean/withpath/{name}")
	public HelloBean helloBeanWithPath(@PathVariable String name) {
		System.out.println("hello api is invoked");
		return new HelloBean(String.format("HelloBean - %s", name));
	}
}
