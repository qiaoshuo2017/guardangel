/*
 * @(#) BaseAction.java 2014-11-14
 * 
 */

package com.makerstreet.hdb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
/**
 * Action的基类,封装Action的公共操作
 * BaseAction.java
 * @author zhuzi 2014-11-14
 * @version 1.0
 */
public class JSONUtil {
	protected final Logger logger = Logger.getLogger(getClass());
	/**
	 * 直接输出指定对象的JSON字符串
	 * @param obj
	 * @author zhuzi
	 */
	public static void outPutJson(Object obj,HttpServletResponse response) {
		if(obj instanceof List) {
			String array = JSONArray.fromObject(obj).toString();
			JsonStringUtils.outputJson(array,response);
		} else if(obj instanceof Object[]) {
			String array = JSONArray.fromObject(obj).toString();
			JsonStringUtils.outputJson(array,response);
		} else {
			JsonStringUtils.outputJson(obj,response);
		}
	}
	
	/**
	 * 直接输出JSON信息(string)
	 * @param successMsg
	 * @author zhuzi
	 */
	public static void jsonSuccessMsg(String successMsg,HttpServletResponse response) {
		Map<String, Object> mobj = new HashMap<String, Object>();
		mobj.put("success", true);
		if (successMsg != null && !"".equals(successMsg)) {
			mobj.put("successMsg", successMsg);
		} else {
			mobj.put("successMsg", "success!");
		}
		outPutJson(mobj,response);
	}
	
	/**
	 * 直接输出JSON信息(string)
	 * @param successMsg
	 * @author zhuzi
	 */
	public static String jsonSuccessMsg1(String successMsg,HttpServletResponse response) {
		Map<String, Object> mobj = new HashMap<String, Object>();
		mobj.put("success", true);
		if (successMsg != null && !"".equals(successMsg)) {
			mobj.put("successMsg", successMsg);
		} else {
			mobj.put("successMsg", "success!");
		}
		outPutJson(mobj,response);
		return null;
	}
	
	/**
	 * 直接输出JOSN信息
	 * @param status	方法boolean结果
	 * @param mess		方法显示信息
	 * @author zhuzi
	 */
	public static void jsonSuccessCode(boolean status,String mess,HttpServletResponse response) {
		Map<String, Object> mobj = new HashMap<String, Object>();
		mobj.put("success", true);
		mobj.put("status", status);
		if (mess != null && !"".equals(mess)) {
			mobj.put("mess", mess);
		} else {
			mobj.put("mess", "success!");
		}
		outPutJson(mobj,response);
	}
	
	public JSONObject parseString(String json){
		return JSONObject.fromObject(json);
	}
	
}

