<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/user-form.css" />
<title>修改密码</title>
</head>
<body>
<div align="center">	
	<s:form action="user_repassword.action" method="post" theme="simple">
		<table>
			<caption >修改密码</caption>
			<tr>
				<td class="f_name"><span style="color:red">*</span>用户名：</td>
				<td class="f_input">
					<s:property value="#session['user.username']"/>
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>旧密码</td>
				<td class="f_input">
					<s:password name="user.password" cssStyle="w200" />
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.password"/>
					<s:fielderror cssStyle="color:red" fieldName="error.password"/> 
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>新密码</td>
				<td class="f_input">
					<s:password name="user.newpassword" cssStyle="w200" />
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.newpassword"/>
				</td>
			</tr>
			<tr>
				<td class="f_name"><span style="color:red;">*</span>确认新密码</td>
				<td class="f_input">
					<s:password name="user.newconfirm" cssStyle="w200"/>
				</td>
				<td>
					<s:fielderror cssStyle="color:red" fieldName="user.newconfirm" />
				</td>
			</tr>
			<tr>
				<td colspan="3" class="btn">
					<s:submit value="修改"></s:submit>
					<s:reset value="重填"></s:reset>
				</td>
			</tr>
		</table>
	</s:form>
</div>
</body>
</html>