<html>
	<body>
		<h1>Cadastro de Jogos</h1>
		
		<?php
			session_start();
			if (isset($_SESSION['MENSAGEM'])) { 
		?>
				<h2 style="color:red;">
					<?=$_SESSION['MENSAGEM']?>
				</h2>
		<?php
				unset($_SESSION['MENSAGEM']);
			}
		?>
		
		<form action="./jogos_controller.php">
			<table>
				<tr>
					<td>Nome</td>
					<td><input type="text" name="nomeJogo"/></td>
				</tr>
				<tr>
					<td>Genero</td>
					<td>
						<select name="genero">
							<option>Aventura</option>
							<option>Corrida</option>
							<option>Terror</option>
							<option>Tiro</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Já jogou ?</td>
					<td>
						<input type="radio" name="jogou" value="sim">Sim</input>
						<input type="radio" name="jogou" value="nao">Não</input>
					</td>
				</tr>
				<tr>
					<td>Imagem Capa</td>
					<td><input type="file" name="nomeImagem"/></td>
				</tr>
				<tr>
					<td>Recomendar</td>
					<td>
						<input type="checkbox" name="recomendar"/>
					</td>
				</tr>				
				<tr>
					<td><input type="submit" value="Adicionar"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>