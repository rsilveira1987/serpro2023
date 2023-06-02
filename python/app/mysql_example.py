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
# importar a biblioteca do MySQL
import mysql.connector

def insertExample(first_name,second_name,email):
    conn = mysql.connector.connect(
        host="127.0.0.1",
        user="root",
        password="root",
        database="mydatabase"
    )

    mycursor = conn.cursor()
    sql_Insert_query = "INSERT INTO tb_accounts (first_name, second_name, email) VALUES (%s, %s, %s)"
    values = (first_name, second_name, email)
    mycursor.execute(sql_Insert_query,values)

    conn.commit()

    print(mycursor.rowcount, "record inserted.")

    # encerra conexao
    conn.close()


def selectExample():
    conn = mysql.connector.connect(
        host="127.0.0.1",
        user="root",
        password="root",
        database="mydatabase"
    )

    mycursor = conn.cursor()
    sql_Select_query = "SELECT * FROM tb_accounts"
    mycursor.execute(sql_Select_query)
    myresult = mycursor.fetchall()

    # encerra conexao
    conn.close()

    for x in myresult:
        print(x)

def selectIdExample(id):
    conn = mysql.connector.connect(
        host="localhost",
        user="root",
        password="root",
        database="mydatabase"
    )
    cursor = conn.cursor()
    sqlQuery = "SELECT * FROM tb_accounts WHERE id = %s" %(id)
    cursor.execute(sqlQuery)
    result = cursor.fetchall()
    for r in result:
        print(r)

def deleteExample(id):
    conn = mysql.connector.connect(
        host="127.0.0.1",
        user="root",
        password="root",
        database="mydatabase"
    )

    mycursor = conn.cursor()
    sql_Delete_query = "DELETE FROM tb_accounts WHERE id = %d" % (id)
    mycursor.execute(sql_Delete_query)

    conn.commit()

    print(mycursor.rowcount, "record(s) deleted.")

    # encerra conexao
    conn.close()


def updateExample(id,first_name,second_name,email):
    conn = mysql.connector.connect(
        host="127.0.0.1",
        user="root",
        password="root",
        database="mydatabase"
    )

    mycursor = conn.cursor()
    sql_Update_query = "UPDATE tb_accounts SET first_name = '%s', second_name = '%s', email = '%s' WHERE id = %d" % (first_name, second_name, email, id)
    mycursor.execute(sql_Update_query)

    conn.commit()

    print(mycursor.rowcount, "record(s) updated.")

    # encerra conexao
    conn.close()
    

if __name__ == '__main__':
    
    selectExample()

    # dictionaryData = {
    #     'first_name':'Ricardo',
    #     'second_name':'Silveira',
    #     'email':'rsilveira1988@gmail.com'
    # }
    # insertExample(**dictionaryData)

    # deleteExample(6)

    # newData = {
    #     'first_name':'Ricardo',
    #     'second_name':'Silveira',
    #     'email':'rsilveira1988@gmail.com'
    # }
    # updateExample(4,**newData)



