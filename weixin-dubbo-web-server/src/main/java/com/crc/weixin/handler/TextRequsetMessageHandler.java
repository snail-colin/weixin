package com.crc.weixin.handler;

import com.crc.weixin.common.weixin.handle.dto.ResponseMessage;
import com.crc.weixin.common.weixin.handle.dto.TextResponseMessage;
import com.crc.weixin.common.weixin.handle.dto.request.RequestMessage;
import com.crc.weixin.common.weixin.handle.dto.request.TextRequestMessage;
import com.crc.weixin.common.weixin.handle.service.RequestMessageHandler;

public class TextRequsetMessageHandler  implements RequestMessageHandler {

	@Override
	public ResponseMessage handle(RequestMessage requestMessage) {
		TextRequestMessage t = (TextRequestMessage) requestMessage;
		TextResponseMessage rst = new TextResponseMessage();
		rst.setCreateTime(System.currentTimeMillis());
		rst.setFromUserName(t.getToUserName());
		rst.setToUserName(t.getFromUserName());
		rst.setMsgType(t.getMsgType());
		rst.setContent("你不要在发了！！！");
		System.out.println(rst);
		return rst;
	}

}
