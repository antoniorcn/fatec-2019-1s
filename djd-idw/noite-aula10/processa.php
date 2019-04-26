<html>
	<head>
	</head>
	<body>
		<?php
			$db = new PDO('mysql:host=localhost;dbname=filmes;charset=utf8', 'root', '');
			print "Conexão OK! <BR>"; 
			$filme = $_REQUEST['FILME'];
	
			$sql = "INSERT INTO filme VALUES ('" . $filme . "')";
			$db->exec($sql);

	
			
			$cmd = $_REQUEST['CMD'];
			echo "Você digitou a resposta $filme<br/>";
			echo "Você apertou o botão $cmd<br/>";
			echo "Arquivo PHP sendo processado<br/>";

			echo "<a href='./quiz.html'>Clique para voltar ao formulario</a>";
		?>
	</body>
</html>