<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
		$(function () {
			$('#b1').click(f1);
		});
		function f1() {
			//serialize表单异步提交时,会生成一个由各个表单域组成的一个请求字符串
			$('#s1').load('loginchecking.do',$('#form1').serialize());
			
		}
		
		function checkUsername() {
			$('#s1').load('checkUsername.do',$('#form1').serialize());
			/* var xhr=null;
			if(window.XMLHttpRequest){
				//非ie浏览器
				xhr=new XMLHttpRequest;
			}else{
				//ie浏览器
				xhr=new ActiveXObjext('MicroSoft.XMLHttp');
			}
			xhr.open('post','checkUsername.do',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					var txt=xhr.responseText;
					console.log(txt);
					$('#s1').text=11;
				}
			};
			xhr.send('username='+$('username').value); */
		} 
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form  method="post" id="form1">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username"  id="username" onblur="checkUsername();"/>
									<span id="s1"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" id="password" name="password"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="button" class="button" value="登录" id="b1"/>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
