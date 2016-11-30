package com.crc.weixin.common.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMapUtil {
	public static Map<String, Object> toMap(int key, String value) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", key);
		map.put("msg", value);
		return map;
	}
	
	
	public static Map<String, Object> toMap(Map<String, Object> map ,int key, String value) {
		map.put("code", key);
		map.put("msg", value);
		return map;
	}
}
