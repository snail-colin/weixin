package com.crc.weixin.service;

import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.crc.weixin.dao.mappers.UserMapper;
import com.crc.weixin.entity.User;
import com.crc.weixin.service.api.UserService;

@Service(register=false, timeout=10000,interfaceClass=UserService.class)
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public Map<String, Object> save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByPrimaryKey(String userNo) {
		return 	userMapper.selectByPrimaryKey(userNo);
	}

}
