<?php

/**
 * Script para testar o acesso ao banco de dados
 * Ex.: php dbConnectionTest.php
 */

    $host       = "127.0.0.1";
    $port       = 5432;
    $dbname     = "mydatabase";
    $user       = "postgres";
    $pass       = "postgres";

    
    try {
        // MySQL
        // $conn = new PDO("mysql:host={$host};port={$port};dbname={$dbname}", $user, $pass);
        
        // PostgreSQL
        $dsn = "pgsql:host=$host;port=$port;dbname=$dbname;";
        $conn = new PDO($dsn, $user, $pass, [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]);
        
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
