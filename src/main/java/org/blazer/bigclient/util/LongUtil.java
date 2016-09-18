package org.blazer.bigclient.util;

/**
 * 处理Long型的参数
 */
public class LongUtil {

	public static Long getLong(Object o) {
		if (o == null) {
			return null;
		}
		try {
			return Long.parseLong(o.toString());
		} catch (Exception e) {
		}
		return null;
	}

	public static Long getLongZero(Object o) {
		if (o == null) {
			return 0L;
		}
		try {
			return Long.parseLong(o.toString());
		} catch (Exception e) {
		}
		return 0L;
	}

}
