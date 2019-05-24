<html>
	<body>
		<h1>Pet Shop</h1>
		<h2>Gestão de Animais</h2>
		<form action="./petshop_controller.php"
			  method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><label>005</label></td>
			</tr>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="NOME"></td>
			</tr>			
			<tr>
				<td>Nascimento</td>
				<td><input type="text" name="NASCIMENTO"></td>
			</tr>					
			<tr>
				<td>Peso</td>
				<td><input type="text" name="PESO"></td>
			</tr>
			<tr>
				<td><button type="submit" value="adicionar">Adicionar</button></td>
				<td><button type="submit" value="pesquisar">Pesquisar</button></td>
			</tr>					
		</table>
		</form>
	</body>
</html>