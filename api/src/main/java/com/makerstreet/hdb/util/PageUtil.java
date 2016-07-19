package com.makerstreet.hdb.util;


public class PageUtil {
	public static boolean count(int count,int num,Integer pagenum){
		//获取list的长度
		System.out.println(count);
		System.out.println(num);
		System.out.println(pagenum);
		if(count%num!=0){
			//有余数的情况
			System.out.println(count/num+1<pagenum);
			if(count/num+1<pagenum){
				return false;
			}else{
				return true;
			}
		}else{
			if(count/num<pagenum){
				return false;
			}else{
				return true;
			}
		}
	}
}
