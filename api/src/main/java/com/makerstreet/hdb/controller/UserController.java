package com.makerstreet.hdb.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.wsdl.Import;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.makerstreet.hdb.model.ResponseModel;
import com.makerstreet.hdb.model.YanzhengmaModel;
import com.makerstreet.hdb.service.impl.UserInterface;
import com.makerstreet.hdb.util.Reruenbean;
import com.makerstreet.hdb.util.Yanzhengma;




@Controller
@RequestMapping("Users")
public class UserController {
	
	@Autowired
	private UserInterface userInterface;
	ResponseModel rm =new ResponseModel();
	@RequestMapping("PhoneTest")
	public @ResponseBody ResponseModel login(
			HttpServletRequest request
			) {
		String MobilePhone= request.getParameter("MobilePhone");
	
		boolean result= userInterface.isPhoneExist(MobilePhone);
		if(result){
			rm.setMethod("PhoneTest");
			rm.setResult("Error");
			rm.setMessage("对不起，手机号已存在");
		}
		else{
			rm.setMethod("PhoneTest");
			rm.setResult("OK");
			rm.setMessage("恭喜您手机号可用");
		}
			return rm;
}
	/*
	 * 发送短信验证码接口
	 * type = 0:	正确返回。可以从api返回的对应字段中取数据。
type > 0:	调用API时发生错误，需要开发者进行相应的处理。
-50 < ctype <= -1:	权限验证失败，需要开发者进行相应的处理。
type <= -50:	系统内部错误，请联系技术支持，调查问题原因并获得解决方案。
	 */
	@RequestMapping("RegisterCode")
	public @ResponseBody ResponseModel RegisterCode(
			HttpServletRequest request,HttpSession session
			) throws IOException, URISyntaxException {
		String mobile= request.getParameter("MobilePhone");
		Reruenbean r=new Reruenbean();
		r=Yanzhengma.send(mobile);
		String number=r.getNumber();
		String code=r.getCode();
		System.out.println(code);
		JSONObject jsonObj = JSONObject.fromObject(code);
		int type =jsonObj.getInt("code");
		System.out.println(type);
		YanzhengmaModel y=new YanzhengmaModel();
		y.setMobile(mobile);
		y.setNumber(number);
		session.setAttribute("yanzhengma", y);
	
		boolean result= userInterface.isPhoneExist(mobile);
		if(result){
			rm.setMethod("RegisterCode");
			rm.setResult("Error");
			rm.setMessage("号码已经注册");
		}
		if(type==0){
			rm.setMethod("RegisterCode");
			rm.setResult("OK");
			rm.setMessage("");
		}
		if(type>0){
			rm.setMethod("RegisterCode");
			rm.setResult("Error");
			rm.setMessage("验证码发送失败");
		}if(type<0){
			rm.setMethod("RegisterCode");
			rm.setResult("Error");
			rm.setMessage("系统内部错误");
		}
			return rm;
}
}

