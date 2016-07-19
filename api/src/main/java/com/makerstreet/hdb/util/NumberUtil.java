package com.makerstreet.hdb.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用来格式数字的方法
 * @author admin
 *
 */
public class NumberUtil {
	/**
	 * 格式化为2位小数
	 * @return
	 */
	public static double toFormat2Bit(double num){
		Integer moneyFix = (int) (num * 100) ;
		num = moneyFix.doubleValue() / 100;
		return num;
	}
	/**
	 * 传进来 数字自动格式化为2位字符串，不够位数左面补0
	 * @param num
	 * @return
	 */
	public static String toFormat2Bit(int num){
		//(2)、如果数字1是整型，如下处理：
		DecimalFormat df=new DecimalFormat("00");
	    String str2=df.format(num);
	    return str2;
	}
	/**
	 * 传进来 数字自动格式化为6位字符串，不够位数左面补0
	 * @param num
	 * @return
	 */
	public static String toFormat6Bit(int num){
		//(2)、如果数字1是整型，如下处理：
		DecimalFormat df=new DecimalFormat("000000");
	    String str2=df.format(num);
		return str2;
	}
	/**
	 * 传进来 数字自动格式化为5位字符串，不够位数左面补5
	 * @param num
	 * @return
	 */
	public static String toFormat5Bit(int num){
		//(2)、如果数字1是整型，如下处理：
		DecimalFormat df=new DecimalFormat("00000");
	    String str2=df.format(num);
		return str2;
	}
	/**
	 * 传进来 数字自动格式化为8位字符串，不够位数左面补0
	 * @param num
	 * @return
	 */
	public static String toFormat3Bit(int num){
		//(2)、如果数字1是整型，如下处理：
		DecimalFormat df=new DecimalFormat("000");
	    String str2=df.format(num);
		return str2;
	}
	
	/**
	 * 判断字符串是否数值 
	 * @param str
	 * @return true:是数值 ；false：不是数值 
	 * @author:WD_SUHUAFU
	 */
	public static boolean isNumber(String str)
    {
        Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]*)?$");
        Matcher match=pattern.matcher(str);
        return match.matches();
    }
	
	public static String toFormat4Bit(int num){
		DecimalFormat dFormat= new DecimalFormat("0000");
		String st2=dFormat.format(num);
		return st2;
	}
	public static String toFormat11Bit(int num){
		DecimalFormat dFormat= new DecimalFormat("00000000000");
		String st2=dFormat.format(num);
		return st2; 
	}
}
