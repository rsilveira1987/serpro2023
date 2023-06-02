#!/usr/local/bin/python
"""
MYSQL Schema
  
  CREATE TABLE `tb_accounts` (
       `id` int(11) NOT NULL AUTO_INCREMENT,
       `first_name` varchar(150) NOT NULL,
       `second_name` varchar(150) DEFAULT NULL,
       `email` varchar(150) NOT NULL,
       PRIMARY KEY (`id`),
       UNIQUE KEY `email` (`email`)
  ) ENGINE = InnoDB; 
"""
# Biblioteca pymsql para conexao com o banco mysql
import pymysql

conn = pymysql.connect(host='localhost',user='root',password='root',database='mydatabase',cursorclass=pymysql.cursors.DictCursor)

with conn.cursor() as c:
    # Criar a consulta e executá-la no banco
    sql = "SELECT * FROM tb_accounts WHERE id = 1"
    c.execute(sql)
    res = c.fetchone() # Método fetchone(): retorna uma linha da tabela em um dicionario
    print(res)
    # Acessar o dado retornado pelo nome da coluna
    print('Usuario encontrado:', res['first_name'])
    print()
    
    # Outra consulta (ainda usando o mesmo cursor)
    # Retornar todas as linhas da tabela de editoras
    sql = "SELECT * FROM tb_accounts"
    c.execute(sql)
    res = c.fetchall() # Método fetchall(): retorna todas as linhas obtidas pela consulta na tabela em uma lista
    print(res)
    print()
