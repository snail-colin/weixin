package com.crc.weixin.service;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.crc.weixin.dao.mappers.UserMapper;
import com.crc.weixin.entity.User;
import com.crc.weixin.service.api.TestService;

@Service(register=false, timeout=10000,interfaceClass=TestService.class)
public class TestServiceImpl implements TestService {

	@Resource
	private UserMapper userMapper;
	
	public String test() {
		User user = new User();
		String no = System.currentTimeMillis() + "";
		user.setUserNo(no);
		user.setUserName("sasasa");
		user.setPassword("sasa");
		user.setCreateDate("20160524");
		user.setUpdateDate("ssasas");
		user.setStatus((byte) 0);
		int rst = userMapper.insert(user);
		System.out.println(rst);
		System.out.println(userMapper.selectByPrimaryKey(no));
		return "suessess";
	}

}
