<?php

	session_start();

	$nome = $_REQUEST['NOME'];
	$nasc = $_REQUEST['NASCIMENTO'];
	$peso = $_REQUEST['PESO'];
	$cmd = $_REQUEST['CMD'];
	

	$db = new PDO(
	'mysql:host=localhost;dbname=petshop;charset=utf8', 
	'root', '');
	print "Conexão OK! <BR>"; 

	if ($cmd == "adicionar") { 
		$sql = "INSERT INTO animais VALUES ('$nome', '$nasc', $peso);";
		$db->exec($sql);
		$_SESSION['MENSAGEM'] = "Animal foi inserido com sucesso";
		header('Location: ./petshop.php');
	} else if ($cmd == "pesquisar") { 
		$sql = "SELECT * FROM animais WHERE nome = '$nome'";
		print "Pesquisando animal";
		$stmt = $db->query($sql);
		$lista = array();
		forEach( $stmt as $registro ) { 
			array_push($lista, $registro);
		}
		$_SESSION['LISTA'] = $lista;
		header('Location: ./petshop.php');
	}
?>