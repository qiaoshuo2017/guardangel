package com.makerstreet.hdb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取Properties 文件的辅助工具类
 * @author zhuzi
 *
 */
public class PropertiesUtil {
	/**
	 * 传入配置文件的地址，配置文件key 获取配置文件key的value值
	 * @param configPath 配置文件相对于本地工程的位置
	 * @param key 
	 * @return 成功返回 value 值  出现异常返回 null
	 */
	public static  String getValue(String configPath,String key){
		//通过类加载器 加载  配置文件 
    	InputStream inputStream = PropertiesUtil.class.getResourceAsStream(configPath);
    	//实例化properties 对象
    	Properties properties = new Properties();
		try {
			//加载 inputStream流获取配置文件信息
			properties.load(inputStream);
			//返回 value值
			return  properties.getProperty(key);
		} catch (IOException e) {
			//出现异常返回  null值
			return null;
		}
	}
}
