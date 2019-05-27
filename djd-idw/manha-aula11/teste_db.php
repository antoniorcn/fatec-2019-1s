<?php
  $id = 0;
  $db = new PDO(
    'mysql:host=localhost;dbname=jogosdb;charset=utf8',
    'root',
    '');
  echo "Conexão OK! <BR>";

  $sql = "INSERT INTO jogos VALUES ( " .
    "$id, 'Mario Bros', 'plataforma', 1, 1, '')";
  $db->exec($sql);
  echo "Comando executado com sucesso <BR>";
?>
