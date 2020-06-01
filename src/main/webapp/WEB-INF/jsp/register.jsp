<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>登录</title>
	<link rel="stylesheet" href="/text2/css/bootstrap.css">
	<link rel="stylesheet" href="bootstrap/css/mylogin.css"> <!-- 本地样式-->
</head>
<body>
<div align="right"><a href="/text2/login">用户登录</a></div>

<div class="container">

	<div class="form row" >
		<div class="form-horizontal col-md-offset-3" id="login_form">
			<h3>注册</h3>
			<div class="col-md-9">
				<form action="/text2/registerCheck">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i>

						<input class="form-control required" type="text" placeholder="账户" id="username" name="username" autofocus="autofocus" maxlength="20"/>
					</div>
					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i>
						<input class="form-control required" type="password" placeholder="输入密码" id="psw" name="password" maxlength="8"/>
					</div>

					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i>
						<input class="form-control required" type="password" placeholder="确认密码" id="rpsw" name="rpassword" maxlength="8"/>
					</div>
					<tr><td><input type="radio" value="zuke" name="type" checked="checked" style="visibility: hidden;"/>

					<div class="form-group col-md-offset-9">
						<button type="submit" class="btn btn-success btn-block" name="submit">提交</button>
					</div>
				</form>




			</div>
		</div>
	</div>
</div>


<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>   <!-- 引入jquery文件 因为bootstrap依赖它-->
<script src="bootstrap/js/bootstrap.js"></script>
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





<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册账号</title>
</head>
<body>
<form action="/Blog_Project/com/blog/servlet/Registerservlet">
用户名称<input type="text" name="uname"/><br>
输入密码<input type="password" name="upwd"/><br>
确认密码<input type="password" name="upwdcheck"/><br>
输入您的性别 <input type="text" name="usex"/><br>
输入您的邮箱<input type="text" name="uemail"/><br>
<input type="submit" value="提交" >
</form>
</body>
</html>    -->
