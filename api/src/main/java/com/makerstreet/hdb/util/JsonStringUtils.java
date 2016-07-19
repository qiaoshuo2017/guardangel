/*
 * @(#)JsonStringUtils.java  2013-8-26
 * 
 * Copyright 2013© 南京尚泽信息技术有限公司, All rights reserved.
 */
package com.makerstreet.hdb.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSON工具类
 *
 * @author zhuzi
 * @version v1.0.0
 */
public class JsonStringUtils {
	
	private static final Log logger = LogFactory.getLog(JsonStringUtils.class);
	
	/**
	 * JavaBean转化为Json字符串
	 *
	 * @param object 标准JavaBean基础信息实例
	 * @return JavaBean-json格式字符串
	 * @author zhuizi
	 */
	public static String javaBeanToJsonString(Object object) {
		return JSONObject.fromObject(object).toString();
	}

	/**
	 * 将标准JavaBean集合转化为Json字符串
	 *
	 * @param obj JavaBean实例对象集合（List<T>,Vector<T>,T[]）
	 * @return JavaBean实例对象集合的Json格式字符串
	 * @author zhuizi
	 */
	public static String collectionToJsonString(Object obj) {
		return JSONArray.fromObject(obj).toString();
	}

	/**
	 * Json格式JavaBean字符串还原为JavaBean实例对象
	 *
	 * @param beanString Json格式JavaBean字符串
	 * @param beanClass =JavaBean类类型
	 * @return  JavaBean实例对象
	 * @author zhuizi
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonStringToJavaBean(String beanString, Class<T> beanClass) {
		beanString = beanString.replaceAll("'null'", "''").replaceAll("\"null\"", "\"\"").replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		JSONObject jsonBean = JSONObject.fromObject(beanString);
		return (T)(JSONObject.toBean(jsonBean, beanClass));
	}

	/**
	 * 将Json格式的JavaBean数据集合字符串转化为标准JavaBean实例对象集合
	 *
	 * @param jsonString Json格式的JavaBean数据集合字符串
	 * @param beanClass JavaBean类类型
	 * @return JavaBean对象实例集合
	 * @author zhuizi
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonStringToCollection(String jsonString, Class<T> beanClass) {
		jsonString = jsonString.replaceAll("'null'", "''").replaceAll("\"null\"", "\"\"").replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		JSONArray jsonList = JSONArray.fromObject(jsonString);
		return (ArrayList<T>) JSONArray.toCollection(jsonList, beanClass);
	}

	/**
	 * 将Json格式的JavaBean数据集合字符串转化为标准JavaBean实例对象数组
	 *
	 * @param jsonString Json格式的JavaBean数据集合字符串
	 * @param beanClass JavaBean类类型
	 * @return JavaBean对象实例数组
	 * @author zhuizi
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] jsonStringToArray(String jsonString, Class<T> beanClass) {
		jsonString = jsonString.replaceAll("'null'", "''").replaceAll("\"null\"", "\"\"").replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		JSONArray jsonList = JSONArray.fromObject(jsonString);
		return (T[])(JSONArray.toArray(jsonList, beanClass));
	}

	/**
	 * 将Json格式的JavaBean数据集合字符串转化为标准JavaBean实例对象数组
	 *
	 * @param jsonString Json格式的JavaBean数据集合字符串
	 * @param beanClass JavaBean类类型
	 * @return JavaBean对象实例数组
	 * @author zhuizi
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[][] jsonStringToTwoDimensionsArray(String jsonString, Class<T> beanClass) {
		jsonString = jsonString.replaceAll("'null'", "''").replaceAll("\"null\"", "\"\"").replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		JSONArray jsonList = JSONArray.fromObject(jsonString);
		T result[][] = null;
		Object array[] = jsonList.toArray();
		for (int i = 0; i < array.length; i++) {
			T temp[] = (T[]) JSONArray.toArray((JSONArray) array[i], String.class);
			if (result == null) {
				result = (T[][])Array.newInstance(String.class, new int[]{ array.length, temp.length });
			}
			result[i] = temp;
		}
		return result;
	}
	
	public static void outputJson(Object obj,HttpServletResponse response) {
		String outStr = "";
		if ((obj instanceof String)) {
			outStr = (String) obj;
		} else {
			outStr = javaBeanToJsonString(obj);
		}
		try {
			if (response != null) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.getWriter().print(outStr);
				if (logger.isDebugEnabled()) {
					logger.debug("printJson:" + outStr);
				}
			} else {
				if (logger.isWarnEnabled()) {
					logger.warn("输出Json时，Response 为空");
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
}
