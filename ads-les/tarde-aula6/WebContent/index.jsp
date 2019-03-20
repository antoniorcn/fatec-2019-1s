<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1>Titulo da pagina principal</h1>
	<p>Paragrafo 1</p>
	<p>Paragrafo 2</p>
	<%
		Date d = new Date();
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	%>
	<p>Data e hora atual são: <%=sdf.format(d)%></p>
</body>
</html>