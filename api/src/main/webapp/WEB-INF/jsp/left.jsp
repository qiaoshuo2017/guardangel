<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CIM管理系统</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/banmaLogo.png" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ui-cupertino/easyui.css">
<link href="${pageContext.request.contextPath}/css/icon.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/lrtk.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/tj.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/list.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/only.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Default.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jiugongge.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/leftMenu.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>

<script type="text/javascript">
	function btnlizhi(id, password) {
		$("#userId").val(id);
		$("#userPW").val(password);

		$('#divYuanGongLiZhi').window('open');
	}

	function btnxiuGai() {
		
		var oldMiMa = $("#oldMiMa").val();
		
		var newMiMa = $("#newMiMa").val();
		
		var againMiMa = $("#againMiMa").val();
		
		if(oldMiMa == null || oldMiMa.trim() == ""){
			layer.msg('请输入原密码！', {
			    time: 1500
			});
			$("#oldMiMa").focus();
			return false;
		}
		if(newMiMa == null || newMiMa.trim() == ""){
			layer.msg('请输入新密码！', {
			    time: 1500
			});
			$("#newMiMa").focus();
			return false;
		}
		
		if(againMiMa == null || againMiMa.trim() == ""){
			layer.msg('请输入确认密码！', {
			    time: 1500
			});
			$("#againMiMa").focus();
			return false;
		}
		
		if (newMiMa != againMiMa) {
			layer.msg('确认密码和新密码不一致！', {
			    time: 1500
			});
			
			return false;
		} 
		
		 $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/changePwd",
				dataType : "json",
				data : {
					"newPwd" :newMiMa ,
					"oldPwd" :oldMiMa 
				},
				success : function(msg) {
					if(msg == -3){
						layer.msg('原密码错误！', {
						    time: 1500
						});
						return false;
					}
					if(msg == -2){
						layer.msg('新密码不能和原密码一致！', {
						    time: 1500
						});
						return false;
					}
					if(msg == -1){
						layer.msg('修改密码失败！', {
						    time: 1500
						});
						return false;
					}
					if(msg == 1){
						layer.msg('修改密码成功！', {
						    time: 1500
						});
						$('#divYuanGongLiZhi').window('close');
						return false;
					}
				},
				error : function(msg) {
				}
			});
	}
	$(function() {
		$("#btnClose").click(function() {
			$('#divYuanGongLiZhi').window('close');
		});
	});
</script>
<style type="text/css">
	.td_left{
		padding-left:4px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 100%;"
		data-options="fit:true">
		<!--头部-->
		<div data-options="region:'north'"
			style="height: 80px; background: #69C repeat-x center 50%; color: #fff">
			<p style="font: 24px '微软雅黑'; padding-left: 20px; padding-top: 20px;">
				CIM管理系统
				<!-- <label style="float:right;">修改密码</label> -->
				<a href="#" onclick="javascript:window.location.href='logout'"
					style="float: right; color: #fff; padding-right: 20px; font-size: 20px;">
					退出 </a> 
				<a href="#"
					onclick="btnlizhi('<%=session.getAttribute("dengLuId")%>','<%=session.getAttribute("dengLuPassword")%>')"
					style="float: right; color: #fff; padding-right: 20px; font-size: 20px;">
					修改密码 </a>
			<p>
		</div>
		<!--底部-->
		<div data-options="region:'south',split:true"
			style="height: 25px; text-align: center; font: 13px '微软雅黑'">版权所有
			@ 南京普雷培训机构</div>
		<!--左侧-->
		<div data-options="region:'west',split:true" title="导航菜单"
			style="width: 300px; height: 100%;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<c:if test="${CURRENT_USER.workRole == 1 }">
					<div title='员工信息管理' style="height: 100%;"
						data-options="selected:true">
						<div class="subNavBox">
							<ul class="navContent" style="display: block">
								<c:if test="${CURRENT_USER.workRole == 1 }">
									<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toInsertWork' onClick='openTab(this)'>增加员工</a>
									<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toSelectWork' onClick='openTab(this)'>查询员工</a>
									<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toUpdateWork' onClick='openTab(this)'>管理员工</a>
								</c:if>
								<c:if test="${CURRENT_USER.workRole == 2 }">
									<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toGroupInfoAndWorks' onClick='openTab(this)'>查询小组信息</a>
								</c:if>
							</ul>
						</div>
					</div>
				</c:if>
				<c:if test="${CURRENT_USER.workRole == 1 || CURRENT_USER.workRole == 2 }">
					<div title='小组信息管理' style="height: 100%;"
						data-options="selected:true">
						<div class="subNavBox">
							<ul class="navContent" style="display: block">
								<c:if test="${CURRENT_USER.workRole == 1 }">
									<li><a href="#" rel='${pageContext.request.contextPath}/group/toInsertGroup' onClick='openTab(this)'>增加小组</a>
									<li><a href="#" rel='${pageContext.request.contextPath}/group/toSelectGroup' onClick='openTab(this)'>查询小组</a>
									<li><a href="#" rel='${pageContext.request.contextPath}/group/toUpdateGroup' onClick='openTab(this)'>管理小组</a>
								</c:if>
								<c:if test="${CURRENT_USER.workRole == 2 }">
									<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toGroupInfoAndWorks' onClick='openTab(this)'>查询小组信息</a>
									<li><a href="#" rel='${pageContext.request.contextPath}/group/toUpdateGroupByLeader' onClick='openTab(this)'>管理小组</a>
								</c:if>
								
							</ul>
						</div>
					</div>
				</c:if>
				<div title='公司信息管理' style="height: 100%;"
					data-options="selected:true">
					<div class="subNavBox">
						<ul class="navContent" style="display: block">
							<c:if test="${CURRENT_USER.workRole == 1 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/compony/toInsertCompony' onClick='openTab(this)'>增加公司</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/compony/toSelectComponyToClient' onClick='openTab(this)'>增加公司联系人</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/compony/toSelectCompony' onClick='openTab(this)'>查询公司</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/compony/toUpdateCompony' onClick='openTab(this)'>管理公司信息</a>
							</c:if>
							<c:if test="${CURRENT_USER.workRole == 2 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toSelectWorks' onClick='openTab(this)'>查询公司</a>
							</c:if>
							<c:if test="${CURRENT_USER.workRole == 3 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/compony/toInsertCompony' onClick='openTab(this)'>增加公司</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/compony/toSelectComponyByWork' onClick='openTab(this)'>员工管理公司</a>
							</c:if>
						</ul>
					</div>
				</div>
				<div title='电话记录管理' style="height: 100%;"
					data-options="selected:true">
					<div class="subNavBox">
						<ul class="navContent" style="display: block">
							<c:if test="${CURRENT_USER.workRole == 1 }">
								<li><a href="#" rel='www.baidu.com' onClick='openTab(this)'>增加电话记录</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/telRecord/toSelectTelRecord' onClick='openTab(this)'>查询电话记录</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/group/toSelectGroupByTelRecord' onClick='openTab(this)'>查询小组所有电话记录</a>
								<li><a href="#" rel='' onClick='openTab(this)'>查询小组所有电话记录</a>
							</c:if>
							<c:if test="${CURRENT_USER.workRole == 2 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toSelectWorksByTelRecord' onClick='openTab(this)'>查询小组所有电话记录</a>
								<li><a href="#" rel='' onClick='openTab(this)'>查询小组所有电话记录</a>
							</c:if>
							<c:if test="${CURRENT_USER.workRole == 3 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/telRecord/toSelectTelRecordByWork?workID=${CURRENT_USER.workID}' onClick='openTab(this)'>查询所有电话记录</a>
							</c:if>
						</ul>
					</div>
				</div>
				<div title='回访电话管理' style="height: 100%;"
					data-options="selected:true">
					<div class="subNavBox">
						<ul class="navContent" style="display: block">
							<li><a href="#" rel='${pageContext.request.contextPath}/revisit/toSelectRevisits' onClick='openTab(this)'>查询回访电话</a></li>
						</ul>
					</div>
				</div>
				<div title='预拨打电话管理' style="height: 100%;"
					data-options="selected:true">
					<div class="subNavBox">
						<ul class="navContent" style="display: block">
							<c:if test="${CURRENT_USER.workRole == 3 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/duetel/toInsertDueTel' onClick='openTab(this)'>新增预拨打电话</a>
								<li><a href="#" rel='${pageContext.request.contextPath}/duetel/toSelectDueTel' onClick='openTab(this)'>查询预拨打电话</a>
							</c:if>
						</ul>
					</div>
				</div>
				
				<div title='统计管理' style="height: 100%;"
					data-options="selected:true">
					<div class="subNavBox">
						<ul class="navContent" style="display: block">
						<c:if test="${CURRENT_USER.workRole == 1 }">
							<li>
								<a href="#" rel='' onClick='openTab(this)'>统计所有电话数</a></li>
								<li><a href="#" rel='' onClick='openTab(this)'>统计所有有效电话数</a></li>
								<li><a href="#" rel='' onClick='openTab(this)'>统计所有无效电话数</a></li>
							</c:if>
							<c:if test="${CURRENT_USER.workRole == 3 }">
								<li><a href="#" rel='${pageContext.request.contextPath}/workInfo/toSelectCountWorks' onClick='openTab(this)'>查询统计</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<c:if test="${CURRENT_USER.workRole == 1 }">
					<div title='提醒信息管理' style="height: 100%;"
						data-options="selected:true">
						<div class="subNavBox">
							<ul class="navContent" style="display: block">
								<li><a href="" rel='www.baidu.com' onClick='openTab(this)'>商户信息查询</a>
								<li><a href="#" rel='' onClick='openTab(this)'>商户信息编辑</a>
								<li><a href="#" rel='' onClick='openTab(this)'>商户交易流水查询</a>
							</ul>
						</div>
					</div>
					<div title='系统设置' style="height: 100%;"
						data-options="selected:true">
						<div class="subNavBox">
							<ul class="navContent" style="display: block">
								<li><a href="" rel='www.baidu.com' onClick='openTab(this)'>设置系统提醒员工电话的相隔时间</a>
								<li><a href="#" rel='' onClick='openTab(this)'>设置每月员工需要完成的有效电话数</a>
								<li><a href="#" rel='' onClick='openTab(this)'>商户交易流水查询</a>
							</ul>
						</div>
					</div>
				</c:if>
				<c:if test="${CURRENT_USER.workRole == 3 }">
					<div title='录入公司管理' style="height: 100%;"
						data-options="selected:true">
						<div class="subNavBox">
							<ul class="navContent" style="display: block">
								<li><a href="#" rel='${pageContext.request.contextPath}/input/toInsertCompony' onClick='openTab(this)'>录入公司信息</a>
							</ul>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<!--右侧-->
		<div region="center" id="mainPanle"
			style="background: #eee; overflow: hidden;">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
				<!-- <div title="主页" style="padding: 20px;" id="home">
					<div id="pp" style="border: 0">
						<div style="width: 30%;"></div>
						<div style="width: 40%;"></div>
						<div style="width: 30%;"></div>
					</div>
				</div> -->
			</div>
		</div>
		<!-- 弹出框 -->
		<div id="divYuanGongLiZhi" class="easyui-window" title="修改密码"
			data-options="modal:true,closed:true,iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:false,closable:false"
			style="width: 300px; height: 250px;padding: 10px;">
			<table cellpadding="10px">
				<tr>
					<td class="td_left">输入原密码：</td>
					<td class="td_left">
						<input id="oldMiMa" type="password" style="width: 172px;" />
					</td>
				</tr>
				<tr>
					<td class="td_left">输入新密码：</td>
					<td class="td_left">
					<input type="password" id="newMiMa" style="width: 172px;" /> 
					</td>
				</tr>
				<tr>
					<td class="td_left">确认密码：</td>
					<td class="td_left">
					
					<input type="password" id="againMiMa" style="width: 172px;" /> 
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						onclick="btnxiuGai()" value="确认修改" id="ygliZhi" />
						&nbsp;&nbsp;&nbsp; <input type="button" value="关  闭" id="btnClose" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>