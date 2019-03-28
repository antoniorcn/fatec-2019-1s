<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat, java.util.List, java.util.ArrayList, edu.curso.Jogo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gestão de Jogos</title>
</head>
<body>

	<h1>Gestão de Jogos</h1>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Jogo jogo = (Jogo)session.getAttribute("JOGO");
		if (jogo == null) { 
			jogo = new Jogo();
		}
		
		String msg = (String)session.getAttribute("MENSAGEM");
		if (msg != null) {
	%>
		<h3 style="color:red;"><%=msg%></h3>
	<%
		session.setAttribute("MENSAGEM", null);
		}
	%>
	<form action="./jogo" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" readonly="readonly"
						value="<%=jogo.getId()%>"/></td>
			</tr>		
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome"
				value="<%=jogo.getNome()%>"/></td>
			</tr>
			<tr>
				<td>Genero</td>
				<td><input type="text" name="genero"
				value="<%=jogo.getGenero()%>"/></td>
			</tr>
			<tr>
				<td>Preco</td>
				<td><input type="text" name="preco"
				value="<%=jogo.getPreco()%>"/></td>
			</tr>
			<tr>
				<td>Lançamento</td>
				<td><input type="text" name="lancamento"
				value="<%=sdf.format(jogo.getLancamento())%>"/></td>
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
			
			<h3>
				<%=j.getId()%> -- 
				<%=j.getNome()%> -- 
				<%=j.getGenero()%> -- 
				<%=j.getPreco()%> -- 
				<%=sdf.format(j.getLancamento())%> -- 
				<a href="./jogo?id=<%=j.getId()%>">Editar</a> -- Remover
			</h3>
			
		<%	}
		}
	%>

</body>
</html>