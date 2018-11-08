<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="css/user-form.css" />
<style type="text/css">

</style>

<script type="text/javascript">
	function retake() {
		targetForm=document.forms[0];
		targetForm.action="user_retake.action";
		targetForm.submit();
	}
</script>

</head>
<body>
<div align="center">
	<!-- 由<form>表单提交后缀为.action的请求，访问也是.action -->
	<!-- Struts2标签 -->
	<s:form action="user_login.action" method="post" theme="simple">
		<!-- 防止多次提交拦截器 -->
		<s:token></s:token>
		<table>
			<caption >用户登录</caption>
			<tr>
				<td class="f_name"><span style="color:red">*</span>用户名：</td>
				<td class="f_input">
					<s:textfield name="user.username" cssStyle="w200"/>
				</td>
				<!-- 校验提示信息 -->
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.username" />
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red">*</span>密码：</td>
				<td class="f_input">
					<s:password name="user.password" cssStyle="w200" />
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.password" />
				</td>
			</tr>
			<!-- 用户名或密码错误提示信息 -->
			<tr>
				<%
					if(request.getAttribute("error")!=null){ 
				%>			
					<td class="tishi" colspan="2"><%=request.getAttribute("error") %></td>
				<%
					} 
				%>
			</tr>
			<tr>
				<td colspan="3" class="btn">
					<s:submit value="登录" />
					<s:reset value="重填"  />
					<s:submit value="找回密码" onclick="javascript:retake();"  />
					<s:a href="register.jsp" cssStyle="font-size:12px;color:#333;">注册</s:a>
				</td>
			</tr>	
		</table>
	</s:form>
</div>
</body>
</html>