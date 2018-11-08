<%-- <%@page import="gxlg.model.Notice"%> --%>
<%@page import="java.util.Date"%>
<%@page import="gxlg.model.*"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
<style type="text/css">

#heads h1{
	color: orange;
	background-color: #eee;
	margin-left:30px;
	float: left;
}

#container{
	width:400px;
	height: 400px;
	margin-left:30px;
	background-color: #eee;
}
#container li{
	margin: 10px 0px;
	color: gray;
}
#container ul li a:link, #container ul li a:visited{
   color: gray;
   text-decoration: none;
}
#container ul li a:hover{
    color: red;
    text-decoration: underline;
}

#repassword{
	padding-left: 90px;
	padding-top: 20px;
	background-color: #eee;
	font-size: 20px;
}
#repassword a:link,#repassword a:visited{
	color: gray;
	padding-left:90px;
   text-decoration: none; 
}
#repassword a:hover{
	 color: blue;
    text-decoration: underline;
}

</style>
</head>
<body>
<div id="heads">
	<%-- <h1>登录成功，欢迎您，<%=session.getAttribute("username") %></h1>
	<h1>登录成功，欢迎您，<s:property value="#session['username']" /></h1>
	<h1>登录成功，欢迎您，<s:property value="#session.username" /></h1> --%>
	<h1>
		<%
			int h24 = (new Date()).getHours();
			pageContext.setAttribute("h24", h24);
		%>
		<s:if test="#attr.h24>5 && #attr.h24<=11">
			<%=session.getAttribute("user.username") %>,上午好！
		</s:if>
		<s:elseif test="#attr.h24>11 && #attr.h24<=13">
			<%=session.getAttribute("user.username") %>,中午好！
		</s:elseif>
		<s:elseif test="#attr.h24>13 && #attr.h24<=18">
			<%-- <%=session.getAttribute("username") %>,下午好！ --%>
			<s:property value="#session['user.username']" />,下午好！
		</s:elseif>
		<s:else>
			<%=session.getAttribute("user.username") %>,晚上好！
		</s:else>
	</h1>
</div>
<div id="repassword">
	<p><a href="repassword.jsp">修改密码</a></p>
	
</div>
<div id="container">
	<div class="module">
		<h2 style="color: white;background-color: #69c6fb;">通知列表</h2>
		<div>
			<ul>
				<%
					//out.print(request.getAttribute("Notices"));
					//获取公告列表
					List<Notice> noticeList = (List<Notice>) session.getAttribute("noticeList");
					//使用增强for循环输出
					for(Notice n : noticeList){
				%>
					<!-- 根据nid显示相应的详细内容 -->
					<li><a href="notice_detail.action?nid=<%= n.getId() %>"><%= n.getTitle() %></a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</div>
</body>
</html>