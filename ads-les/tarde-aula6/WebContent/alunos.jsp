<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, edu.curso.Aluno" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1>Gestão de Alunos</h1>
	<form action="./aluno" method="post">
		<table>
			<tr>
				<td>RA:</td>
				<td><input type="text" name="ra"/></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome"/></td>
			</tr>
			<tr>
				<td>Idade:</td>
				<td><input type="text" name="idade"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Adicionar"/></td>
			</tr>		
		</table>
	</form>
	<table>
		<thead>
			<tr>
				<th>RA</th>
				<th>Nome</th>
				<th>Idade</th>
			</tr>
		</thead>
		<tbody>
	<%
		List<Aluno> lista = (List<Aluno>)application.getAttribute("ALUNOS");
	
		if (lista == null) { 
			lista = new ArrayList<>();
		}
		
		for(Aluno a : lista) {
	%>
			<tr>
				<td><%=a.getRa()%></td>
				<td><%=a.getNome()%></td>
				<td><%=a.getIdade()%></td>
			</tr>
		<% }  %>
		</tbody>
	</table>
</body>
</html>