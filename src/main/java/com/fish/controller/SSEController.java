package com.fish.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sse")
public class SSEController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/sse", produces="text/event-stream;charset=UTF-8")
	@ResponseBody
	public String sse() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "number : " + new Random().nextInt();
	}
}
