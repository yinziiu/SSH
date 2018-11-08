<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="css/user-form.css" />
<style type="text/css">

</style>
</head>
<body>
<div align="center">	
	<s:form action="user_register.action" method="post" theme="simple">
		<table id="register_box">
			<caption >用户注册</caption>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>用户名</td>
				<td class="f_input">
					<s:textfield name="user.username" cssStyle="w200"/>
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.username" />
					<s:fielderror cssStyle="color:red" fieldName="error.username" />
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>密码</td>
				<td class="f_input">
					<s:password name="user.password" cssStyle="w200" />
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.password"/>
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>确认密码</td>
				<td class="f_input">
					<s:password name="user.confirm" cssStyle="w200"/>
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.confirm" />
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>邮箱</td>
				<td class="f_input">
					<s:textfield name="user.email" cssStyle="w200" />
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.email" />
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>生日</td>
				<td class="f_input">
					<s:textfield name="user.birthday" cssStyle="w200" />
				</td>
				<td>
					(格式要求：20010825)
					<s:fielderror cssStyle="color:red" fieldName="user.birthday" />
				</td>
			</tr>
			<tr>
				<td colspan="3" class="btn">
					<s:submit value="注册"></s:submit>
					<s:reset value="重填"></s:reset>
				</td>
			</tr>
		</table>
	</s:form>
</div>
</body>
</html>