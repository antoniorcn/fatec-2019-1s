<html>
	<body>
		<h1>Pet Shop</h1>
		<h2>Gestão de Animais</h2>
		<?php
			session_start();
			if (isset($_SESSION['MENSAGEM'])) {
		?>
				<h3><?=$_SESSION['MENSAGEM']?></h3>
		<?php
				unset($_SESSION['MENSAGEM']);
			}
		?>			
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
				<td><button type="submit" name="CMD" value="adicionar">Adicionar</button></td>
				<td><button type="submit" name="CMD" value="pesquisar">Pesquisar</button></td>
			</tr>					
		</table>
		</form>
		<?php
			if (isset($_SESSION['LISTA'])) {
				$lista = $_SESSION['LISTA'];
				foreach($lista as $registro) {
		?>
					<h3><?=$registro['nome']?></h3>
					<h3><?=$registro['nascimnto']?></h3>
					<h3><?=$registro['peso']?></h3>
		<?php
				}
			}
		?>	
		
		
	</body>
</html>