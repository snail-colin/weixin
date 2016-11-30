package com.crc.weixin.common.util.dto;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {

	private Integer key;
	
	private String value;

	public ResultMap() {
	}
	
	public ResultMap(Integer key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
		return;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		return;
	}
	
	public Map<String,Object> toMap(){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", key);
		map.put("msg", value);
		return map;
	}
	
	
}
