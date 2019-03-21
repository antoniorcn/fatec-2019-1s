<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, edu.curso.Jogo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gestão de Jogos</title>
</head>
<body>

	<h1>Gestão de Jogos</h1>
	
	<form action="./jogo" method="post">
		<table>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome"/></td>
			</tr>
			<tr>
				<td>Genero</td>
				<td><input type="text" name="genero"/></td>
			</tr>
			<tr>
				<td>Preco</td>
				<td><input type="text" name="preco"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Adicionar"/></td>
			</tr>
		</table>
	</form>
	
	<%
		List<Jogo> lista = (List<Jogo>)application.getAttribute("LISTA");
		if (lista == null) { 
			lista = new ArrayList<>();
		} else { 
			for (Jogo j : lista) { 	%>
			
			<h3><%=j.getNome()%> -- <%=j.getGenero()%> -- <%=j.getPreco()%></h3>
			
		<%	}
		}
	%>

</body>
</html>