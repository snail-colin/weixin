package com.crc.weixin.common.weixin.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.crc.weixin.common.util.ConvertorUtil;
import com.crc.weixin.common.weixin.api.dto.Menu;

public class MenuApi extends BaseApi {

	private final static String MENU_API_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create";

	/**
	 * 创建微信菜单
	 * 
	 * @param access_token
	 * @param menus
	 * @param result
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void create(String access_token, List<Menu> menus, Map<String, Object> result) throws IOException {
		String url = MENU_API_CREATE + "?access_token=" + access_token;
		String jsonStr = convertToJson(menus);
		PostMethod method = new PostMethod(url);
		try {
			method.getParams().setContentCharset(CONTENT_CHARSET);
			HttpClient httpClient = new HttpClient();
			RequestEntity requestEntity = new StringRequestEntity(jsonStr, "application/x-www-form-urlencoded",
					"utf-8");
			method.setRequestEntity(requestEntity);
			int status = httpClient.executeMethod(method);
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

	/**
	 * 转换成json格式
	 * @param menus
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private static String convertToJson(List<Menu> menus)
			throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> rst = new LinkedHashMap<String, Object>();
		rst.put("button", menus);
		return ConvertorUtil.specialMapToJson(rst);
	}
}
