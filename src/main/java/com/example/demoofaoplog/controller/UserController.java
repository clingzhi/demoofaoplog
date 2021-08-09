package com.example.demoofaoplog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/hello")
	public String toSayHello(@RequestParam("name") String name) throws Exception{
		System.out.println("你好："+name);
		return "你好："+name;
	}
}
