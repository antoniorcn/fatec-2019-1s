<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.util.List, java.util.ArrayList, edu.curso.AluguelCarro, java.text.SimpleDateFormat" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<title>Aluguel de Carros</title>
	
	<script>
		function pesquisar() { 
			var form = document.getElementById("formulario");
			var tagData = document.getElementById("dataAluguel");
			alert("Data : " + tagData.value);
			form.submit();
			
		}
	</script>
	
</head>
<body>
	<h1>Aluguel de Carros</h1>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AluguelCarro ac = (AluguelCarro)
							session.getAttribute("ALUGUEL");
		if (ac == null) { 
			ac = new AluguelCarro();
			ac.setDataInicio(new Date());
			ac.setModeloCarro("");
		}
		String msg = (String)session.getAttribute("MENSAGEM");
		if (msg != null) { 
	%>
	<h3 style="color:red;"><%=msg%></h3>
	<%
			session.setAttribute("MENSAGEM", null);
		}
	%>
	<form id="formulario" action="./aluguelCarros" method="post">
		<table>
			<tr>
				<td>Id do Aluguel:</td>
				<td><input type="text" name="id" readonly="readonly" 
							value="<%=ac.getId()%>"/></td>
			</tr>
			<tr>
				<td>Modelo Carro:</td>
				<td>
					<select name="modeloCarro">
						<option value="fiat_uno" 
						<%=ac.getModeloCarro().equals("fiat_uno")?"selected":""%>
							>Fiat Uno</option>
						<option value="renault_logan"
						<%=ac.getModeloCarro().equals("renault_logan")?"selected":""%>
							>Renault Logan</option>
						<option value="renault_duster"
						<%=ac.getModeloCarro().equals("renault_duster")?"selected":""%>
							>Renault Duster</option>
						<option value="renault_kwid"
						<%=ac.getModeloCarro().equals("renault_kwid")?"selected":""%>
							>Renault Kwid</option>
						<option value="toyota_prius"
						<%=ac.getModeloCarro().equals("toyota_prius")?"selected":""%>
							>Toyota Prius</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Data do Aluguel:</td>
				<td><input type="date" name="dataAluguel" id="dataAluguel" 
					value="<%=sdf.format(ac.getDataInicio())%>"/>
					<button type="submit" class="btn btn-primary btn-sm" 
							name="cmd" value="pesquisar">
    					<span class="glyphicon glyphicon-search"></span> Search
  					</button>
				</td>
			</tr>
			<tr>
				<td>Dias de Aluguel:</td>
				<td><input type="number" name="diasAluguel"
							value="<%=ac.getDias()%>"/></td>
			</tr>			
			<tr>
				<td>
					<% if (ac.getId() == 0) {%>
						<button type="submit" name="cmd" value="adicionar" class="btn btn-primary">
						Adicionar
						</button>
					<% } else { %>
						<button type="submit" name="cmd" value="salvar" class="btn btn-primary">
						Salvar
						</button>
					<% } %>
				</td>
				<td>
					<button type="submit" name="cmd" value="pesquisarTodos" class="btn btn-primary">
					Pesquisar Todos
					</button>
				</td>
				
			</tr>		
		</table>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Modelo Carro</th>
				<th>Data</th>
				<th>Dias</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
	<%
		List<AluguelCarro> lista = (List<AluguelCarro>)session.getAttribute("ENCONTRADOS");
		if (lista == null) { 
			lista = new ArrayList<>();
		}
		for(AluguelCarro a : lista) {
	%>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getModeloCarro()%></td>
				<td><%=sdf.format(a.getDataInicio())%></td>
				<td><%=a.getDias()%></td>
				<td>
					<a href="./aluguelCarros?id=<%=a.getId()%>">
						Editar
					</a>  -   Remover
				</td>
			</tr>
		<% }  %>
		</tbody>
	</table>
</body>
</html>