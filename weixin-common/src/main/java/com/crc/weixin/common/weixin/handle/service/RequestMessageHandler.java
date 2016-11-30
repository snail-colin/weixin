package com.crc.weixin.common.weixin.handle.service;

import com.crc.weixin.common.weixin.handle.dto.ResponseMessage;
import com.crc.weixin.common.weixin.handle.dto.request.RequestMessage;

public interface RequestMessageHandler {
	
	public ResponseMessage handle(RequestMessage requestMessage);
}
