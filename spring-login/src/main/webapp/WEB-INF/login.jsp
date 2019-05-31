<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body style="font-size:30px;">
	<form action="login.do" method="post">
		<fieldset>
			<legend>登录</legend>
			用户名:<input name="username"/>
			
			<span style="color:red">${login_failed}</span>
			密码:<input type="password" name="pwd"/>
			验证码:<input name="number"/>
			<span style="color:red;">${number_error}</span>
			<a href="javascript:;" onclick="document.getElementById('img1').src='checkcode.do?'+Math.random();"><img  src="checkcode.do" id="img1"/></a>
			<input type="submit" value="登录"/>
		</fieldset>
	</form>
</body>
</html>