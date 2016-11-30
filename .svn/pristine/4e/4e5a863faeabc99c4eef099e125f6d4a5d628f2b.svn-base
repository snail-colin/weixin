package com.crc.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crc.weixin.service.api.TestService;

@RequestMapping("/weixin")
@Controller
public class TestController {

	
	@Reference(interfaceClass=TestService.class,check=false)
	TestService testService;
	
	@RequestMapping
	public  String index(){
		testService.test();
		return "test-index";
	}
	
}
