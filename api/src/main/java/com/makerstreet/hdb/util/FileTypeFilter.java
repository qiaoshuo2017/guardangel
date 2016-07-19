package com.makerstreet.hdb.util;

import java.io.File;
/**
 * 传入文件父目录，指定文件过滤器   ，返回所有指定文件的格式的file list
 * @author zhuzi
 */
public class FileTypeFilter {
//	public static void main(String[] args) {
//		String rootString="E:\\project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\hd\\upload\\C0000000120150828027\\0";
//		File[] files = getFile(rootString, "jpg");
//		for (File file : files) {
//			ThumbnailUtil.toSmallJpg(rootString+"/"+file.getName());
//		}
//		
//	}
	 /**
	  * 传入后缀 返回 所有File数组
	  * @param suffix 后缀名
	  * @return
	  */
	 public static File[] getFile(String rootPath,String suffix){
		  File directory = new File(rootPath);
		  //列出所有.jpg文件并对其进行压缩
		  //列出所有.java文件
		  File[] files = directory.listFiles(new FileNameSelector(suffix));
		  return files;
	 }
	 
	 
}
