<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, java.util.ArrayList, edu.curso.AluguelCarro, java.text.SimpleDateFormat" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Aluguel de Carros</title>
</head>
<body>
	<h1>Aluguel de Carros</h1>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AluguelCarro ac = (AluguelCarro)
							session.getAttribute("ALUGUEL");
		if (ac == null) { 
			ac = new AluguelCarro();
		}
		String msg = (String)session.getAttribute("MENSAGEM");
		if (msg != null) { 
	%>
	<h3 style="color:red;"><%=msg%></h3>
	<%
			session.setAttribute("MENSAGEM", null);
		}
	%>
	<form action="./aluguelCarros" method="post">
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
				<td><input type="date" name="dataAluguel" 
					value="<%=sdf.format(ac.getDataInicio())%>"/></td>
			</tr>
			<tr>
				<td>Dias de Aluguel:</td>
				<td><input type="number" name="diasAluguel"
							value="<%=ac.getDias()%>"/></td>
			</tr>			
			<tr>
				<td><input type="submit" value="Adicionar"/></td>
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
		List<AluguelCarro> lista = (List<AluguelCarro>)application.getAttribute("ALUGUEIS");
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