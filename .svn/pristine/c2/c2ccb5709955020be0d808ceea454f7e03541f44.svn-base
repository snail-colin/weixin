package com.crc.weixin.common.weixin.handle.dto;

public enum MsgType {

	TEXT("text", "TextRequestMessage"), IMAGE("image", "ImageRequestMessage");
	
	//类路径
	private static final String CLASS_PATH = "com.crc.weixin.common.weixin.handle.dto.";

	private String msgType;
	private String className;

	private MsgType(String msgType, String className) {
		this.msgType = msgType;
		this.className = className;
	}

	public static String getName(String type) {
		for (MsgType msgType : MsgType.values()) {
			if (msgType.getMsgType().equals(type)) {
				return CLASS_PATH + msgType.className;
			}
		}
		return null;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
