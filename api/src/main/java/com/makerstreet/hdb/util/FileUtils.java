/*
 * @(#)FileUtils.java  2013-8-26
 * 
 * Copyright 2013© 南京尚泽信息技术有限公司, All rights reserved.
 */
package com.makerstreet.hdb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件操作工具类
 *
 * @author zhuzi
 * @version v1.0.0
 */
public class FileUtils {
	/**
	 * 文件重命名(短时间内多个文件一起重名，避免名字冲突)
	 * 
	 * @param file
	 *            重命名文件
	 * @param fileName
	 *            重命名文件名
	 * @return 新的名称
	 * @author zhuzi
	 */
	public static String fileReName(File file, String fileName) {
		if (null == file) {
			return null;
		}
		// String prefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new
		// Date());
		String prefix = new SimpleDateFormat("HHmmssSSS").format(new Date());
		if (fileName.contains(".")) {
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			fileName = prefix + suffix;
		}
		return fileName;
	}

	/**
	 * 文件重命名(短时间内多个文件一起重名，避免名字冲突)
	 * 
	 * @param fileName   重命名文件名
	 * @return 新的名称
	 * @author zhuzi
	 */
	public static String filesReName(String fileName) {
		//前缀当前系统时间
		String prefix =  new SimpleDateFormat("HHmmssSSS").format(new Date());
		//判断文件名是否包含“.”,从而判断是否是文件，如果没有包含就停止操作
		if (fileName.contains(".")) {
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			fileName = prefix + suffix;
		}
		return fileName;
	}

	/**
	 * 保存文件
	 *
	 * @param file
	 *            待保存文件
	 * @param fileName
	 *            保存文件名
	 * @param realPath
	 *            真实路径
	 * @return
	 * @author zhuzi
	 */
	public static boolean saveFile(File file, String fileName, String realPath) {
		File fileDir = new File(realPath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		File out = new File(fileDir, fileName);
		try {
			FileCopyUtils.copy(file, out);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 传入文件的输入流和文件路径以及文件的文件名进行保存文件的方法
	 * 
	 * @param stream
	 *            文件的字节流
	 * @param path
	 *            文件上传的路径
	 * @param filename
	 *            文件名
	 * @throws IOException
	 *             可能抛出io异常
	 */
	public static void SaveFileFromInputStream(InputStream stream, String path,
			String filename) throws IOException {
		//通过path路径实例化File对象
		File file= new File(path);
		//如果文件夹没有存在则创建文件夹
		if(!file.exists()){
			//可以创建多级子目录
			file.mkdirs();
		}
		// 实例化一个文件字节输出流，通过路径加上文件名
		FileOutputStream fs = new FileOutputStream(path + "/" + filename);
		// 实例化字节数组，用于读写文件
		byte[] buffer = new byte[1024 * 1024];
		//已读自己变量
		int byteread = 0;
		// 进行文件读写操作
		while ((byteread = stream.read(buffer)) != -1) {
			fs.write(buffer, 0, byteread);
			//刷新文件流
			fs.flush();
		}
		// 流对象关闭操作
		fs.close();
		stream.close();
	}
	/**
	 * 传入 指定的参数 进行保存对象
	 * @param file 二进制文件对象
	 * @param filePath 文件保存路径
	 * @param request shiFouJueDuiLuJing 
	 * 				  1 或则其它数字: 表示 是绝对路径 
	 * 				  0: 表示 是相对路径
	 * @param request request请求对象
	 * @throws IOException io异常
	 */
	public static String SaveFileFromInputStream(MultipartFile file, String filePath,int shiFouJueDuiLuJing,ServletRequest request) throws IOException {
		//首先对文件名进行改变，防止文件名字重复
		String fileName = file.getOriginalFilename();//文件名
		//获取本地文件磁盘的绝对路径
		//如果是 相对路径标示 则 获取 项目本地工程的 绝对路径
		String path = null;
		String prefix =  new SimpleDateFormat("yyyyMMdd").format(new Date());
		if(shiFouJueDuiLuJing == 0){
			path = request.getServletContext().getRealPath(filePath);
			//在指定文件路径下面创建一个 当天日期字符串文件夹
			path=path+"/"+prefix;
			//文件更改后的名字
			String fileReName = FileUtils.filesReName(fileName);
			//进行文件上传
			FileUtils.SaveFileFromInputStream(file.getInputStream(), path, fileReName);
			return filePath+ "/" + fileReName;
		}else{
			filePath+="/" + prefix;
			//文件更改后的名字
			String fileReName = FileUtils.filesReName(fileName);
			//进行文件上传
			FileUtils.SaveFileFromInputStream(file.getInputStream(), filePath, fileReName);
			return "/" + prefix+ "/" + fileReName;
		}
	}
}
