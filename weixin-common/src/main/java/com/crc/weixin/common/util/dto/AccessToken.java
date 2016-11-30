package com.crc.weixin.common.util.dto;

public class AccessToken{

	/**
	 * access_token是公众号的全局唯一接口调用凭据
	 */
	public String access_token;
	
	/**
	 * 有效时长（秒）默认1小时
	 */
	public int expiresIn = 60;

	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expiresIn=" + expiresIn + "]";
	}
	
}
