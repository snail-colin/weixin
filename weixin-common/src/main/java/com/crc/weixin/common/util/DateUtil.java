package com.crc.weixin.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换工具
 * 
 * @author colin 2016/07/28
 */
public class DateUtil {

	/**
	 * 获取系统当前日期 格式: yyyyMMddHHmmss
	 */
	public static String getNowDate2yyyyMMddHHmmss() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
}
