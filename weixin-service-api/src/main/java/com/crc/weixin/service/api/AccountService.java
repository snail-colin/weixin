package com.crc.weixin.service.api;

import java.util.List;
import java.util.Map;

import com.crc.weixin.entity.Account;

public interface AccountService {

	/**
	 *  绑定微信公众号
	 * @param account
	 * @return
	 */
	public Map<String, Object> save(Account account);
	
	
	/**
	 *  更新绑定微信号信息
	 * @param account
	 * @return
	 */
	public Map<String, Object> update(Account account);
	
	
	/**
	 * 删除绑定微信号
	 * @param accountNo
	 * @return
	 */
	public Map<String, Object> delete(String accountNo);
	
	
	/**
	 * 删除绑定微信号
	 * @param accountNo
	 * @return
	 */
	public Map<String, Object> deleteByAccountNos(String[] accountNo);
	
	/**
	 * 根据主键获取绑定的公众号
	 * @param accounto
	 * @return
	 */
	public Account getByAccountNo(String accountNo);
	
	
	/**
	 * 获取用户下所有公众号列表数据
	 * @param userNo
	 * @return
	 */
	public List<Account> getListByUserNo(String userNo);



}
