package com.makerstreet.hdb.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class SendSms {

	public static void main(String[] args) {
		SendSms sms = new SendSms();
		try {
			// 自动生成六位验证码
			String vCode = sms.makeValidateCode();
			// 发送短信
			boolean state = sms.sendValidateCode("15851811660", vCode);
			System.out.println(state);
			//System.out.println(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据手机号码发送动态验证码
	 * 
	 * @param phoneNomber
	 *            :手机号码
	 * @param vCode
	 *            :动态验证码
	 * @return 发送状态，true：发送成功； false：发送失败
	 * @throws Exception
	 */
	public boolean sendValidateCode(String phoneNomber, String vCode)
			throws Exception {
		// String msg = vCode + "(动态验证码)，请在30分钟内填写";
		//System.out.println("进入JJJJJJJJJ");

		String msg = "【斑马金服】欢迎使用斑马金服,您的手机验证码为:" + vCode + ",本条信息无需回复。";
		String url = "http://114.215.192.27:9001/sms.aspx?action=send&userid=3839&account=jdzc&password=jdcf123..&mobile="
				+ phoneNomber + "&content=" + msg + "&sendTime=&extno=";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);
		//System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		line = rd.readLine();
		line = rd.readLine();
		if (line.indexOf("Success") < 0) {
			//System.out.println("失败");
			return false;
		} else {
			//System.out.println("成功");
			return true;
		}
	}
	
	public boolean sendlingshimima(String phoneNomber, String vCode)
			throws Exception {
		// String msg = vCode + "(动态验证码)，请在30分钟内填写";
		//System.out.println("进入JJJJJJJJJ");

		String msg = "【慧网金服】欢迎使用慧网金服,您的临时密码为:" + vCode + "请登录后修改密码。本条信息无需回复";
		String url = "http://114.215.192.27:9001/sms.aspx?action=send&userid=3839&account=jdzc&password=jdcf123..&mobile="
				+ phoneNomber + "&content=" + msg + "&sendTime=&extno=";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);
		//System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		line = rd.readLine();
		line = rd.readLine();
		if (line.indexOf("Success") < 0) {
			//System.out.println("失败");
			return false;
		} else {
			//System.out.println("成功");
			return true;
		}
	}

	/**
	 * 产生指定位数的数字验证码
	 * 
	 * @param bits
	 *            指定的位数
	 * @return 产生的数字验证码
	 */
	public String makeValidateCode(int bits) {
		Random random = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < bits; i++) {
			list.add(random.nextInt(10));
		}
		StringBuffer sBuffer = new StringBuffer();
		for (Integer item : list) {
			sBuffer.append(item);
		}

		return sBuffer.toString();
	}

	/**
	 * 产生6位数的数字验证码
	 * 
	 * @return 产生的数字验证码
	 */
	public String makeValidateCode() {
		return makeValidateCode(6);
	}
	
	public static boolean checkvcode(HttpSession session,String yanzhengma){
		String vcode=(String) session.getAttribute("vcode");
		System.out.println(yanzhengma.equals(vcode));
		System.out.println(yanzhengma);
		System.out.println(vcode);
		//判断验证的长度是否是 6位如果不是六位  左面补0
		yanzhengma = NumberUtil.toFormat6Bit(Integer.parseInt(yanzhengma));
		if(yanzhengma.equals(vcode)){
			return true;
		}else{
			return false;
		}
	}
}
