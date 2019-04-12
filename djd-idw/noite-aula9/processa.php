<html>
	<head>
	</head>
	<body>
		<?php
			$valor = $_REQUEST['RESPOSTA'];
			$cmd = $_REQUEST['CMD'];
			echo "Você digitou a resposta $valor<br/>";
			echo "Você apertou o botão $cmd<br/>";
			echo "Arquivo PHP sendo processado<br/>";
			
			if ($valor == "42") { 
		?>
				<h2>Parabéns vc acertou</h2>
		<?php
			} else { 
		?>
				<h2>Vc errou</h2>
		<?php  }
			echo "<a href='./quiz.html'>Clique para voltar ao questionario</a>";
		?>
	</body>
</html>