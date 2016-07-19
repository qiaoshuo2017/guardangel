<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0059)https://www.wpcom.cn/member/login?from=%2Fmember%2Fregister -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta charset="UTF-8">
<title>登录 - cim</title>
<link href="${pageContext.request.contextPath }/css/login/login.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.message_cn.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.method.js"></script>
<%-- 	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/cim/login.js"></script> --%>
<script>
	$(function() {
		var reflushPageFlag = "${reflushPageFlag}";
		if(reflushPageFlag != null && reflushPageFlag == "true"){
			parent.location.reload();
		}
		//开始验证
		$("#submitForm").validate({
			rules : {
				dengLuMing : {
					required : true,
				},
				dengLuMiMa : {
					required : true,
					minlength : 6,
				}
			},
			messages : {
				dengLuMing : {
					required : "请输入用户名！",
				},
				dengLuMiMa : {
					required : "请输入密码",
					minlength : "密码长度不能小于6位！",
				}
			},
			/* 重写错误显示消息方法,以alert方式弹出错误消息 */
			showErrors : function(errorMap, errorList) {
				if (errorList.length == 0) {
					return;
				}
				var errorObj = errorList[0];
				var errorObjId = errorObj.element.id;
				var msg = errorObj.message;
				if (msg != "") {
					layer.msg(msg, {
						time : 2000
					//不自动关闭
					});
					$("#" + errorObjId).focus();
				}
				;
			},
			submitHandler : function() {
				//提交登录请求
				$.ajax({
					   type: "POST",
					   url: "/hdb/login",
					   data: $("#submitForm").serialize(),
					   success: function(msg){
						   console.log(msg);
						   if(msg == -1){
							   layer.msg("账户信息异常，请联系管理员！");
						   }else if(msg == 0){
							   layer.msg("用户名或者密码输入错误！");
						   }else if(msg == 1){
							   window.location.href="/hdb/left";
						   }else if(msg == 2){
							   layer.msg("你已经被禁用！如有疑问，请联系管理员！");
						   }
					   }
					});
			},
			/* 失去焦点时不验证 */
			onfocusout : false,
			onkeyup : false
		});
	});
</script>
</head>
<body>
	<div class="form">
		<div class="form-bg"></div>
		<div class="form-inner">
			<a class="logo" href="#"><img
				src="${pageContext.request.contextPath }/img/login/logo-blue.png"
				width="154" alt="WPCOM"></a>
			<div id="j-errmsg" class="errmsg alert alert-warning"></div>
			<form id="submitForm" method="post">
				<div class="input-group">
					<span class="input-group-addon input-label">用户名</span> <input
						type="text" class="form-control require" id="dengLuMing"
						name="dengLuMing" placeholder="用户名"
						style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
				</div>
				<div class="input-group">
					<span class="input-group-addon input-label">密<span
						class="vh">一</span>码
					</span> <input type="password" class="form-control require"
						id="dengLuMiMa" name="dengLuMiMa" placeholder="登录密码"
						style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
				</div>
				<!-- <div class="checkbox">
                <label><input type="checkbox" id="rememberme" name="rememberme" value="true">记住我的登录信息</label>
            </div> -->
				<div class="last">
					<input class="btn btn-primary btn-block btn-lg" type="submit"
						id="submit" value="登  录">
				</div>
			</form>
			<p class="alert alert-info register">
				<a data-toggle="modal" data-target="#rBox" href="#">找回密码</a> | <a
					href="#">马上注册</a>
			</p>
		</div>
	</div>
	<script id="hiddenlpsubmitdiv" style="display: none;"></script>