package com.crc.weixin;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crc.weixin.common.util.ResultMapUtil;
import com.crc.weixin.common.util.dto.PageBean;
import com.crc.weixin.commons.BaseController;
import com.crc.weixin.entity.Account;
import com.crc.weixin.service.api.AccountService;
import com.crc.weixin.service.api.MenuService;


@Controller
@RequestMapping("/weixin/account")
class AccountController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Reference(interfaceClass=AccountService.class,check=false)
	AccountService accountService;
	
	@Reference(interfaceClass=MenuService.class,check=false)
	MenuService menuService;
	
	@RequestMapping
	public ModelAndView index(){
		return new ModelAndView("account-index");
	}
	
	
	/**
	 * 绑定公众号
	 * @param account
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Map<String, Object> create(Account account){
		return accountService.save(account);
	}
	
	/**
	 * 更新公众号
	 * @param account
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Map<String, Object> update(Account account){
		return accountService.update(account);
	}
	
	/**
	 * 解除绑定
	 * @param accountNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public Map<String, Object> delete(String[] accountNo){
		if(accountNo == null || accountNo.length == 0)
			return ResultMapUtil.toMap(-1, "请指定需要解除绑定的公众号");
		return accountService.deleteByAccountNos(accountNo);
	}
	
	/**
	 * 分页获取列表数据
	 * @param pageBean
	 * @param userNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Map<String, Object> list(PageBean pageBean,String userNo){
		
		return null;
	}
}
