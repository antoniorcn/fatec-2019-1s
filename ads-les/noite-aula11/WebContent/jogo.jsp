<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat, java.util.List, java.util.ArrayList,edu.curso.controller.Jogo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gestão de Jogos</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
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
				<td>
					<select name="genero">
						<option value="acao" 
							<%=jogo.getGenero().equals("acao")?"selected" : ""%>>Ação</option>
						<option value="aventura"
							<%=jogo.getGenero().equals("aventura")?"selected" : ""%>>Aventura</option>
						<option value="labirinto"
							<%=jogo.getGenero().equals("labirinto")?"selected" : ""%>>Labirinto</option>
						<option value="plataforma"
							<%=jogo.getGenero().equals("plataforma")?"selected" : ""%>>Plataforma</option>
						<option value="rpg"
							<%=jogo.getGenero().equals("rpg")?"selected" : ""%>>RPG</option>
					</select>
				</td>
				
				<%-- <input type="text" 
				value="<%=jogo.getGenero()%>"/></td> --%>
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
				<td>
					<%if (jogo.getId() == 0) { %>
						<input type="submit" name="cmd" value="Adicionar"/>
					<% } else { %>
						<input type="submit" name="cmd" value="Salvar"/>					
					<% } %>
				</td>
				<td>
					<input type="submit" name="cmd" value="Pesquisar"/>
				</td>
			</tr>
		</table>
	</form>
	
	<%
		List<Jogo> lista = (List<Jogo>)session.getAttribute("ENCONTRADOS");
		if (lista == null) { 
			lista = new ArrayList<>();
		} else { 
	%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Genero</th>
					<th>Preço</th>
					<th>Lançamento</th>
					<th>Ações</th>
				</tr>
			</thead>
				<tbody>
	<%
			for (Jogo j : lista) { 	%>
			<tr>
				<td><%=j.getId()%></td> 
				<td><%=j.getNome()%></td> 
				<td><%=j.getGenero()%></td> 
				<td><%=j.getPreco()%></td> 
				<td><%=sdf.format(j.getLancamento())%></td> 
				<td>
					<a href="./jogo?cmd=editar&id=<%=j.getId()%>">Editar</a> - 
					<a href="./jogo?cmd=remover&id=<%=j.getId()%>">Remover</a>
				</td>
			</tr>		
		<%	} %>
			</tbody>
		</table>
		<% }  %>
</body>
</html>