package com.crc.weixin.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.crc.weixin.common.util.dto.ResultMap;
import com.crc.weixin.common.weixin.api.MenuApi;
import com.crc.weixin.dao.mappers.MenuMapper;
import com.crc.weixin.entity.Menu;
import com.crc.weixin.service.api.MenuService;

@Service(register=false, timeout=10000,interfaceClass=MenuService.class)
public class MenuServiceImpl extends BaseService implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	

	@Override
	public Map<String, Object> save(Menu menu) {
		int rst = menuMapper.insertSelective(menu);
		if(rst > 0 )
			return new ResultMap(0,"保存成功").toMap();
		return new ResultMap(-1,"保存失败").toMap();
	}
	

	@Override
	public Map<String, Object> syncMenu(String accountNo,List<Menu> menus) {
		Map<String, Object> rst = new HashMap<String,Object>();
		if(menus != null && menus.size() > 0 ){
			String token = getCacheToken(accountNo);
			try {
				MenuApi.create(token, bulidWeixinMenus(menus), rst);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rst;
	}
	
	/**
	 * 构建微信菜单
	 * @param menus
	 * @return
	 */
	private List<com.crc.weixin.common.weixin.api.dto.Menu> bulidWeixinMenus(List<Menu> menus){
		List<com.crc.weixin.common.weixin.api.dto.Menu> rst = new ArrayList<com.crc.weixin.common.weixin.api.dto.Menu>();
		for (Menu menu : menus) {
			com.crc.weixin.common.weixin.api.dto.Menu tempMenu = new com.crc.weixin.common.weixin.api.dto.Menu();
			if(StringUtils.isNotBlank(menu.getMenuKey()))
				tempMenu.setKey(menu.getMenuKey());
			if(StringUtils.isNotBlank(menu.getMediaId()))
				tempMenu.setMedia_id(menu.getMediaId());
			if(StringUtils.isNotBlank(menu.getName()))
				tempMenu.setName(menu.getName());
			if(StringUtils.isNotBlank(menu.getType()))
				tempMenu.setType(menu.getType());
			if(StringUtils.isNotBlank(menu.getParent())){
				List<Menu> childMenus = menuMapper.selectByAccountNoAndParent(menu.getAccountNo(),menu.getParent());
				tempMenu.setSub_button(bulidWeixinMenus(childMenus));
			}	
			rst.add(tempMenu);
		}
		return rst;
	}

	public List<Menu> getMenuByAccountNoAndParent(String accountNo, String parent) {
		return menuMapper.selectByAccountNoAndParent(accountNo,parent);
	}

	
	
}
