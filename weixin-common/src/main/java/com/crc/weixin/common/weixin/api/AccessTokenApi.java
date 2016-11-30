package com.crc.weixin.common.weixin.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author colin
 *
 */
public class AccessTokenApi extends BaseApi {

	private final static String TOKEN_API = "https://api.weixin.qq.com/cgi-bin/token";



	/**
	 * 获取access_token
	 * 
	 * @param appid
	 * @param secret
	 * @return
	 * @throws IOException
	 */
	public static String getAccessToken(String appid, String secret) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		getAccessToken(appid, secret, result);
		if (result.get("access_token") != null)
			return (String) result.get("access_token");
		return null;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 * @param secret
	 * @param result
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void getAccessToken(String appid, String secret, Map<String, Object> result) throws IOException {
		String grantType = "client_credential";
		String url = TOKEN_API + "?grant_type=" + grantType + "&appid=" + appid + "&secret=" + secret;
		GetMethod method = new GetMethod(url);
		try {
			method.getParams().setContentCharset(CONTENT_CHARSET);
			HttpClient client = new HttpClient();
			int status = client.executeMethod(method);
			if (status == HttpStatus.SC_OK) {
				if (result != null) {
					String response = method.getResponseBodyAsString();
					Map<String, Object> json = objectMapper.readValue(response, Map.class);
					result.putAll(json);
				}
			}
		} finally {
			method.releaseConnection();
		}
	}

}
