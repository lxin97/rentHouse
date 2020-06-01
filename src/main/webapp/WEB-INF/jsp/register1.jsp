<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天天租房系统</title>
<link rel="stylesheet" type="text/css" href="/text2/css/styles.css">
</head>
<body>
<div align="right"><a href="/text2/login">用户登录</a></div>
<div class="wrapper">

	<div class="container">
		<h1>欢迎注册</h1>
<%--		<form class="form" id="loginform" action="logincheck.action" method="post">
			<div><input type="text" name="username" placeholder="用户名" ></div>
			<div><input type="password" name="password" placeholder="密码" ></div>
			<div>
		<label class="radio inline">
      	  	<input id="admin" type="radio" name="type" value="admin"  checked/> 管理员
		</label>
		<label class="radio inline">
			<input id="zuke" type="radio" name="type" value="zuke" } /> 租客
		</label>
		</div>

			<button type="submit" id="login-button">登录</button>
		</form>--%>

		<form action="/text2/registerCheck" id="loginform" method="get" enctype="multipart/form-data" id="registerform">
			<tr><td >账户：</td><td align="left"><input  type="text" name="username" /></td></tr>
			<tr><td >密码：</td><td align="left"><input type="password" name="password" id="psw"/></td></tr>
			<tr><td >确认密码：</td><td align="left"><input type="password" name="rpassword" id="rpsw" onblur="checkpwd()"/>
				<span id="nameSpan"></span>
			</td></tr>
			<tr><td><input type="radio" value="zuke" name="type" checked="checked" style="visibility: hidden;"/>
			<tr><td colspan="2">
				<button type="submit" id="login-button" value="注册" onclick="registercheck()"/><span style="color: red">${error}</span></td></tr>

		</form>
	</div>

	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>

</div>

<script type="text/javascript" src="/text2/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/text2/js/jquery.validate.min.js"></script>
<script type="text/javascript"
    src="/text2/js/localization/messages_zh.js"></script>
<script type="text/javascript">

	function checkpwd(){
		//获取name的值
		var pwd = document.getElementById("psw").value;
		var rpwd = document.getElementById("rpsw").value;
		var onameSpan = document.getElementById("nameSpan");
		onameSpan.innerHTML = "";
		if(pwd==rpwd){
			//满足后，检测是否已经存在
			//alert(1)

		}else{
			onameSpan.innerHTML = "密码不一致".fontcolor("red");
		}
	}
	function registercheck(){
		//获取name的值
		var onameSpan = document.getElementById("nameSpan");
		checkpwd();
		if(onameSpan.innerHTML=="" || onameSpan.innerHTML==null){
			//满足后，检测是否已经存在

			alert(111)
		}else{
			alert("请确认密码")
			onameSpan.innerHTML=""
			var oform=document.getElementById("registerform")
			oform.action="/text2/register"
		}
	}

</script>
</body>
</html>
