package com.crc.weixin.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.crc.weixin.common.util.DateUtil;
import com.crc.weixin.common.util.ResultMapUtil;
import com.crc.weixin.dao.mappers.UserMapper;
import com.crc.weixin.entity.Account;
import com.crc.weixin.entity.User;
import com.crc.weixin.service.api.AccountService;

@Service(register = false, timeout = 10000, interfaceClass = AccountService.class)
public class AccountServiceImpl extends BaseService implements AccountService {

	@Resource
	private UserMapper userMapper;

	@Override
	public Map<String, Object> save(Account account) {
		User user = userMapper.selectByPrimaryKey(account.getUserNo());
		if (user == null)
			return ResultMapUtil.toMap(-1, "用户不存在");
		String createDate = DateUtil.getNowDate2yyyyMMddHHmmss();
		account.setCreateDate(createDate);
		account.setUpdateDate(createDate);
		int rst = accountMapper.insertSelective(account);
		if (rst > 0)
			return ResultMapUtil.toMap(0, "保存成功");
		return ResultMapUtil.toMap(-1, "保存失败");
	}

	@Override
	public Map<String, Object> update(Account account) {
		User user = userMapper.selectByPrimaryKey(account.getUserNo());
		if (user == null)
			return ResultMapUtil.toMap(-1, "用户不存在");
		Account oldAccount = accountMapper.selectByPrimaryKey(account.getAccountNo());
		if (oldAccount == null)
			return ResultMapUtil.toMap(-1, "未绑定公众号");
		account.setUpdateDate(DateUtil.getNowDate2yyyyMMddHHmmss());
		int rst = accountMapper.updateByPrimaryKeySelective(account);
		if (rst > 0)
			return ResultMapUtil.toMap(0, "更新成功");
		return ResultMapUtil.toMap(-1, "更新失败");
	}

	@Override
	public Map<String, Object> delete(String accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteByAccountNos(String[] accountNo) {
		int rst = accountMapper.batchDeleteByAccountNos(Arrays.asList(accountNo));
		if (rst > 0)
			return ResultMapUtil.toMap(0, "成功解除绑定");
		return ResultMapUtil.toMap(-1, "解除绑定失败");
	}

	@Override
	public Account getByAccountNo(String accountNo) {
		return accountMapper.selectByPrimaryKey(accountNo);
	}

	@Override
	public List<Account> getListByUserNo(String userNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
