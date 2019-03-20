<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h3> Pagina de Teste em JSP </h3>
	<h2> Este código esta em JSP </h2>
	<%
		out.println("Este código mostra a tabuada do número 7");
		for (int i = 1; i <= 7; i++ ) { 
	%>
			<h4> 7 X <%=i%> = <%=(i * 7)%> </h4>
	<%
		}
	%>
<h2> Fim da Tabuada </h2>
</body>
</html>