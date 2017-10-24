package com.cjh.cc.security.signature;

import com.cjh.cc.common.util.MD5Util;
import com.cjh.cc.security.Constant;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;



/**
 * 签名工具类
 */
public class SignatureUtil {

	/**
	 * 创建签名
	 * @param parameters
	 * @return
	 */
	public static String createSign(SortedMap<Object, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<Object, Object>> es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
		Iterator<Entry<Object, Object>> it = es.iterator();
		while (it.hasNext()) {
			Entry<Object, Object> entry = (Entry<Object, Object>) it
					.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + Constant.SIGNATURE_KEY);
		String sign = MD5Util.MD5(sb.toString()).toUpperCase();
		return sign;
	}

}
