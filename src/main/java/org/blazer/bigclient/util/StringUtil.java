package org.blazer.bigclient.util;

/**
 * 字符串参数处理工具
 */
public class StringUtil {

	/**
	 * 校验为空串
	 *
	 * @param o
	 * @return
	 */
	public static String getStrEmpty(Object o) {
		return o == null ? "" : o.toString();
	}

	/**
	 * 校验为null
	 *
	 * @param o
	 * @return
	 */
	public static String getStr(Object o) {
		return o == null ? null : o.toString();
	}

}
