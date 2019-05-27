<h1>Jogos Controller</h1>
<?php
	$nome = $_REQUEST['nomeJogo'];
	$genero = $_REQUEST['genero'];
	$jogou = ($_REQUEST['jogou'] == 'sim');
	$imagem = $_REQUEST['nomeImagem'];
	$rec = ($_REQUEST['recomendar'] == 'on');
	$id = 0;
	$db = new PDO( 'mysql:host=localhost;dbname=jogosdb;charset=utf8', 'root', ''
	);
	echo "Conexão OK! <BR>";
	$sql = "INSERT INTO jogos VALUES ( " .
		"$id, '$nome', '$genero', $jogou, $rec, '$imagem')";
	$db->exec($sql);
	echo "Comando executado com sucesso <BR>";
?>