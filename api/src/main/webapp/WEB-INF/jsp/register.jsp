<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ui-cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-error-validate.css">
<style type="text/css">
.demo-rtl .portal-column-left {
	padding-left: 10px;
	padding-right: 10px;
}

.demo-rtl .portal-column-right {
	padding-left: 10px;
	padding-right: 0;
}

.red {
	color: #ff0000;
	padding-left: 10px;
	font-size: 12px;
}

.inputs {
	border: 1px solid #A9A9A9;
	width: 173px;
	float: left;
}
#pagefenye ul {
	padding: 4px 0;
	margin: 0;
	overflow: hidden;
	margin-top: 10px;
}
#pagefenye ul li {
	display: inline;
	padding: 5px;
	margin: 0px 5px;
}
#pagefenye ul li a {
	color: #428bca;
    text-decoration: none;
}
#pagefenye .active {
	background-color: #3BAAE3;
	padding: 5px 10px;
	color: #fff;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.portal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.message_cn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.method.js"></script>
<script type="text/javascript">
	$(function(){
			 //开始验证
		    $("#siRenForm").validate({ 
		    	 rules:{
		 	    	dengLuMiMa:{
		 	    		required: true,  
		 	    	    minlength: 6  
		 	    	},
		 	    	queRendengLuMiMa:{
		 	    		required: true,  
		 	    	    minlength: 6,  
		 	    	    equalTo: "#dengLuMiMa"  
		 	    	},
		 	    	dengLuDianHua:{
		 	    		required: true
		 	    	},
		 	    	dengLuYouXiang:{
	  	 	    	 required: true,  
	  	 	     	 email: true  
	  	 	    	}
				 },
				 messages:{
	                dengLuMiMa:{
               		    required: "请输入密码",  
               		    minlength: "密码不能小于6个字符"
	  	 	    	},
	  	 	    	queRendengLuMiMa:{
	  	 	    		 required: "请输入确认密码",  
	  		  	 	     minlength: "确认密码不能小于6个字符",  
	  		  	 	     equalTo: "两次输入密码不一致！"
	  	 	    	},
	  	 	    	dengLuDianHua:{
	  	 	    	  required: "请输入电话！"  
	  	 	    	},
	  	 	    	dengLuYouXiang:{
	  	 	    		required: "请输入Email地址！",  
	  	 	    	    email: "请输入正确的email地址！"   
	  	 	    	}
				 }
				 ,
				 errorClass: "invalid" //验证错误的样式
				 , 
				 invalidHandler: function(form, validator) {  //不通过回调 
					 
				 }
		});
	 });
</script>
<title>商用户管理</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/dengLu/registers" id="siRenForm" method="post">
		<div>
			<div class="tb">
				<div class="chuangkou">
					<img src="${pageContext.request.contextPath}/img/chuangkou.gif" width="100%">
				</div>
				<div style="float: left; padding-top: 10px;">
					<span style="font-weight: bold;">用户新增</span>
				</div>
			</div>
			<br />
			<div class="easyui-accordion" style="width: 99%;">
				<div title="用户新增" data-options="iconCls:'icon-ok'"
					style="overflow: auto; padding: 10px;">
					<table  cellspacing="10px" cellpadding="10px">
						<tr>
							<td>登录邮箱：</td>
							<td colspan="2"><input style="width: 170px" type="text"
								name="dengLuYouXiang" id="dengLuYouXiang" />
								<div id="jiGouMingCheng_prompt" class="red"></div></td>
						</tr>
						<tr>
							<td>登录电话：</td>
							<td colspan="2">
							<input style="width: 170px" type="text"
								name="dengLuDianHua" id="dengLuDianHua" />
								<div id="jiGouMingCheng_prompt" class="red"></div></td>
						</tr>
						<tr>
							<td>登录密码：</td>
							<td colspan="2">
							<input style="width: 170px" type="password" name="dengLuMiMa"
								id="dengLuMiMa" />
								<div id="jiGouMingCheng_prompt" class="red"></div></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td colspan="2">
							<input style="width: 170px" type="password" name="queRendengLuMiMa"
								id="queRendengLuMiMa" />
								<div id="neirong_prompt" class="red"></div></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="submit" value="提交" id ="siRenSubmit"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		</form>
	<br />
</body>
</html>