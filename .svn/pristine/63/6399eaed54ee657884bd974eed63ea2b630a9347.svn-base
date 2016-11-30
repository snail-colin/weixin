package com.crc.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crc.weixin.service.api.MenuService;


@Controller
@RequestMapping("/weixin/menu")
public class MenuController {

	@Reference(interfaceClass=MenuService.class,check=false)
	MenuService menuService;
	
	@RequestMapping
	public String index(){
		
		return "menu-index";
	}
}
