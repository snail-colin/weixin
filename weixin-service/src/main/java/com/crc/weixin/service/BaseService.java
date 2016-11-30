package com.crc.weixin.service;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.crc.weixin.common.util.CacheUtil;
import com.crc.weixin.common.util.dto.AccessToken;
import com.crc.weixin.common.weixin.api.AccessTokenApi;
import com.crc.weixin.dao.mappers.AccountMapper;
import com.crc.weixin.entity.Account;

public class BaseService {

	@Resource
	protected AccountMapper accountMapper;
	
	/**
	 * 获取缓存的token值
	 * @param account
	 * @return
	 */
	protected String getCacheToken(String accountNo){
		String cacheToken = "";
		if(StringUtils.isNotBlank(accountNo)) {
			AccessToken accessToken = CacheUtil.getCache(AccessToken.class, accountNo);
			if(accessToken == null){
				//无缓存数据则重新添加到缓存中
				Account account = accountMapper.selectByPrimaryKey(accountNo);
				if(account != null){
					String token = getToken(account.getAppId(),account.getAppSecret());
					accessToken = new AccessToken();
					accessToken.access_token=token;
					try {
						CacheUtil.updateCache(accountNo, accessToken.expiresIn, accessToken);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			cacheToken = accessToken.access_token;
		}
		return cacheToken;
	}
	
	/**
	 * 获取微信token
	 * @param appid
	 * @param secret
	 * @return
	 */
	private String getToken(String appid,String secret){
		String token = "";
		try {
			token = AccessTokenApi.getAccessToken(appid, secret);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}
}
