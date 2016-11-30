package com.crc.weixin.common.weixin.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.crc.weixin.common.util.ConvertorUtil;
import com.crc.weixin.common.weixin.api.dto.Menu;

public class BaseApi {
	public final static ObjectMapper objectMapper = new ObjectMapper();

	public final static String CONTENT_CHARSET = "UTF-8";

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Menu menu = new Menu();
		menu.setKey("aa");
		List<Menu> list = new ArrayList<Menu>();
		list.add(menu);
		System.out.println(ConvertorUtil.listToJson(list));
	}
}
