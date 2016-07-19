package com.makerstreet.hdb.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 对于中文路径请求 进行编码
 * 
 */
public class UrlFilter implements Filter {
	/*默认URL编码个是*/
	public final static String DEFAULT_URI_ENCODE = "UTF-8";
    private FilterConfig config = null;
    private String encode = null;
	     
	
    public UrlFilter() {
    }
	public void destroy() {
		config = null;
	}

	/**
	 * 对于路径进行 url解码
	 * 解码成utf-8格式编码
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		  HttpServletRequest request = (HttpServletRequest) req;
		  //设置请求参数编码
	        String uri = request.getRequestURI();
	        String ch = URLDecoder.decode(uri, encode);
	        //获取所有的 参数名 对参数值做乱码解决
	        request.setCharacterEncoding("UTF-8");
	        if(uri.equals(ch)) {
	            chain.doFilter(req, res);
	            return;
	        }
	        ch = ch.substring(request.getContextPath().length());
	        config.getServletContext().getRequestDispatcher(ch).forward(req, res);
	}
	/**
	 * 在初始化方法里面获取配置参数
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
        this.encode = config.getInitParameter("DEFAULT_URI_ENCODE");
        if(this.encode == null) {
            this.encode = DEFAULT_URI_ENCODE;
        }
	}

}
