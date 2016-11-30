package com.crc.weixin.handler;

import java.io.IOException;
import java.util.LinkedHashSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.crc.weixin.common.weixin.handle.BaseHandlerServlet;
import com.crc.weixin.common.weixin.handle.service.RequestMessageHandler;

public class WechatCallbackApiHandlerServlet extends BaseHandlerServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MessageHandlerConfig messageHandlerConfig;

	private ApplicationContext applicationContext;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext()); 
		messageHandlerConfig = (MessageHandlerConfig) applicationContext.getBean("weixinMessageHandler");
	}

	@Override
	protected void messageHandler(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException {
		super.messageHandler(request, response);
	}

	@Override
	protected LinkedHashSet<RequestMessageHandler> getRequestMessageHandlers() {
		return messageHandlerConfig.getRequestMessageHandlers();
	}


}
