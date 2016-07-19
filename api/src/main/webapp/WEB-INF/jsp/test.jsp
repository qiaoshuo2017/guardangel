<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/hdb/UserController/yanzhengma" id="validateCodeImg" onclick="changeImg()">
 <script type="text/javascript">
      //刷新验证码
      function changeImg(){
          document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/hdb/UserController/yanzhengma?"+Math.random();
     }
     </script>
</body>
</html>