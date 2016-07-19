package com.makerstreet.hdb.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件过滤器 指定accpt的后缀 ，可以进行文件过滤
 * 
 * @author zhuzi
 *
 */
public class FileNameSelector implements FilenameFilter {
	String extension = ".";

	public FileNameSelector(String fileExtensionNoDot) {
		extension += fileExtensionNoDot;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
}