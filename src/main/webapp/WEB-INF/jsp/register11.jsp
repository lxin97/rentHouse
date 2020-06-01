<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style type="text/css">
		table{
			margin: 7% 25% ;
			width: 350px;
			background: aliceblue;
			text-align: center;
			border: 1px solid black;

		}
		.box{

			width: 100%;
			height: 650px;
			background: url("${pageContext.request.contextPath}/1.jpg");
			border: 1px solid red;
/*			margin:100px 0px 0px 0px ;
			padding: 0px 0px 0px 140px;*/
		}
	</style>
</head>
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
<body ><div class="box">
<div align="right"><a href="/text2/login">用户登录</a></div>

	<table  cellspacing="0" cellpadding="0" >
		<form action="/text2/registerCheck" method="get" enctype="multipart/form-data" id="registerform">
			<tr ><td colspan="2"><h2 >注册</h2></td></tr>
			<tr><td >账户：</td><td align="left"><input  type="text" name="username" /></td></tr>
			<tr><td >密码：</td><td align="left"><input type="password" name="password" id="psw"/></td></tr>
			<tr><td >确认密码：</td><td align="left"><input type="password" name="rpassword" id="rpsw" onblur="checkpwd()"/>
				<span id="nameSpan"></span>
			</td></tr>
			<tr><td><input type="radio" value="zuke" name="type" checked="checked" style="visibility: hidden;"/>
			<tr><td colspan="2"><input type="reset" value="重置" />
				<input type="submit" value="注册" onclick="registercheck()"/><span style="color: red">${error}</span></td></tr>

		</form></table>
</div>
</body>
</html>