<?php

	$nome = $_REQUEST['NOME'];
	$nasc = $_REQUEST['NASCIMENTO'];
	$peso = $_REQUEST['PESO'];
	
	$db = new PDO(
	'mysql:host=localhost;dbname=petshop;charset=utf8', 
	'root', '');
	print "Conexão OK! <BR>"; 
	//		$filme = $_REQUEST['FILME'];
	//
	//		$sql = "INSERT INTO filme VALUES ('" . $filme . "')";
	//		$db->exec($sql);

?>