package com.crc.weixin.service.api;

import java.util.List;
import java.util.Map;

import com.crc.weixin.entity.Menu;

public interface MenuService {
	
	/**
	 * 创建菜单
	 * @param menu
	 * @return
	 */
	public Map<String, Object> save(Menu menu);

	/**
	 * 同步微信菜单
	 * @param accountNo
	 * @param menus
	 * @return
	 */
	public Map<String, Object> syncMenu(String accountNo,List<Menu> menus);
	
	/**
	 * 根据参数获取菜单列表
	 * @param accountNo
	 * @param parent
	 * @return
	 */
	public List<Menu> getMenuByAccountNoAndParent(String accountNo,String parent);
}
