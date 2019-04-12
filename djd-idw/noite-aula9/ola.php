<h1>Hello World PHP</h1>

<?php 
	// Comentario
	$a = 0;
	$nome = "Antonio";
	$a = $a + 1;
	$lista = array(1, 2, 3, 4, 5, 6);
	array_push($lista, 7, 8, 9);
	$texto = "";
	for ($i = 0; $i < count($lista); $i++) { 
		$texto = $texto . $lista[$i] . " - ";
	}
	echo "Texto elaborado em PHP -  " . $texto;

?>

<h2>Outro texto</h2>