<?php

/**
 * Script para testar o acesso ao banco de dados
 * Ex.: php dbConnectionTest.php
 */

    $host       = "127.0.0.1";
    $port       = 3306;
    $dbname     = "mydatabase";
    $user       = "root";
    $pass       = "root";

    
    try {
        // Cria um DSN para conectar em um banco de dados MYSQL
        $conn = new PDO("mysql:host={$host};port={$port};dbname={$dbname}", $user, $pass);

        // Habilita PDO exceptions (para debug)
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);        

        // Cria um objet statement
        $stmt = $conn->prepare("SELECT * FROM tb_accounts");
        $stmt->execute();
        
        // Retorna os dados em forma de objeto
        $response = $stmt->fetchAll(PDO::FETCH_OBJ);

        print_r($response);

    } catch (Exception $e) {
        print $e->getMessage() . PHP_EOL;
    }
