<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Iutf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String path = (String)session.getAttribute("path"); 
	out.println(path);
	%>
	<p>Login in</p>
</body>
</html>