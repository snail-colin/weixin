package com.crc.weixin.common.weixin.handle.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * xml 过度类
 * @author colin
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="xml")
public class ConvertRequestMessage {
	
	@XmlElement(name = "MsgType")
	public String msgType;
	
	@XmlElement(name = "Event")
	public String event;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "ConvertRequestMessage [msgType=" + msgType + ", event=" + event + "]";
	}
	
}
