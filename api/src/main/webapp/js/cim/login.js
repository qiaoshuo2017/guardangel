/*登录界面的js*/
$(function(){
	$("#submit").click(function(){
		//判断用户名和密码是否为null 
		var name = $("#dengLuMing").val().trim();
		var dengLuMiMa = $("#dengLuMiMa").val().trim();
		if(name == null || name == ""){
			layer.msg('请输入用户名');
			return false;
		}
		if(dengLuMiMa == null || dengLuMiMa == ""){
			layer.msg('请输入密码');
			return false;
		}
		
		return false;
	});
});