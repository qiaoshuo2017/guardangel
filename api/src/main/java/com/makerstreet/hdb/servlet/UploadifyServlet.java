package com.makerstreet.hdb.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * uploadify 上传文件控制 servlet
 */
public class UploadifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UploadifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			chuCiShangChuan(request,response);
	}
	/**
	 * 初次调用上传的审核资料调用的 方法
	 * 直接创建文件夹进行  传输文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void chuCiShangChuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String index = request.getParameter("index");
		String xiangMuBianHao = request.getParameter("xiangMuBianHao");
		String savePath =request.getSession().getServletContext().getRealPath("/")+"upload/"+xiangMuBianHao+"/"+index+"/"; 
		File f1 = new File(savePath);  
		//System.out.println(savePath);  
		if (!f1.exists()) {  
		    f1.mkdirs();  
		}  
		DiskFileItemFactory fac = new DiskFileItemFactory();  
		ServletFileUpload upload = new ServletFileUpload(fac); 
		upload.setHeaderEncoding("utf-8");  
		List fileList = null; 
		try {  
		    fileList = upload.parseRequest(request);  
		} catch (FileUploadException ex) {  
		}  
		Iterator<FileItem> it = fileList.iterator();  
		String name = "";  
		String extName = "";  
		while (it.hasNext()) {  
		    FileItem item = it.next();  
		    if (!item.isFormField()) {  
		        name = item.getName();  
		        //System.out.println(size + " " + type);  
		        if (name == null || name.trim().equals("")) {  
		            continue;  
		        }  
		        // 扩展名格式：  
		        if (name.lastIndexOf(".") >= 0) {  
		            extName = name.substring(name.lastIndexOf("."));  
		        }  
		        File saveFile = new File(savePath + name );
		        try {  
		            item.write(saveFile);  
			        response.getWriter().write(  name + extName); 
			        response.getWriter().close();
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		    }  
		   
		}  
	}
	
	
}
