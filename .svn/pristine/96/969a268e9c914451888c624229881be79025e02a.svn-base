package com.crc.weixin.handler;

import java.util.LinkedHashSet;

import com.crc.weixin.common.weixin.handle.service.RequestMessageHandler;

public class MessageHandlerConfig {

	private static final LinkedHashSet<RequestMessageHandler> requestMessageHandlers = new LinkedHashSet<RequestMessageHandler>();

	public LinkedHashSet<RequestMessageHandler> getRequestMessageHandlers() {
		return requestMessageHandlers;
	}

	public static void setRequestMessageHandlers(
			LinkedHashSet<RequestMessageHandler> requestMessageHandlersSet) {
		requestMessageHandlers.clear();
		requestMessageHandlers.addAll(requestMessageHandlersSet);
	}

}