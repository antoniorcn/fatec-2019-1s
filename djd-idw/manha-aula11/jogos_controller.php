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
		"$id, :nome, :genero, :jogou, :rec, :imagem)";
	$stmt = $db->prepare($sql);
	$stmt->bindValue(':nome', $nome, PDO::PARAM_STR);
	$stmt->bindValue(':genero', $genero, PDO::PARAM_STR);
	$stmt->bindValue(':jogou', $jogou, PDO::PARAM_INT);
	$stmt->bindValue(':rec', $rec, PDO::PARAM_INT);
	$stmt->bindValue(':imagem', $imagem, PDO::PARAM_STR);
	$stmt->execute();
	$result = $stmt->rowCount();
	echo "Comando executado com sucesso <BR>";
	header('Location: ./jogos.php');
	$msg = "Jogo cadastrado com sucesso";
	
	session_start();
	$_SESSION['MENSAGEM'] = $msg;
?>