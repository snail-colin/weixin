package com.crc.weixin.service.api;

import java.util.Map;

import com.crc.weixin.entity.User;

public interface UserService {

	Map<String, Object> save();
	
	User getUserByPrimaryKey(String userNo);
	
}
