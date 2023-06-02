#!/usr/local/bin/python

import psycopg2

def selectAllExample():
    try:
        connection = psycopg2.connect(
            host="localhost",
            user="postgres",
            password="postgres",
            database="mydatabase"
        )
        connection.set_session(autocommit=True)
        cursor = connection.cursor()
        sqlQuery = "SELECT * FROM tb_accounts"
        cursor.execute(sqlQuery)
        print("Selecting all rows from tb_accounts table using cursor.fetchall")
        records = cursor.fetchall() # retorna tuplas
        for row in records:
            print(row)


    except (Exception, psycopg2.Error) as error:
        print("Error while fetching data from PostgreSQL", error)
    finally:
        # closing database connection.
        if connection:
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")

def selectManyExample(number):
    try:
        connection = psycopg2.connect(
            host="localhost",
            user="postgres",
            password="postgres",
            database="mydatabase"
        )
        cursor = connection.cursor()
        sqlQuery = "SELECT * FROM tb_accounts"
        cursor.execute(sqlQuery)
        print("Selecting all rows from tb_accounts table using cursor.fetchmany")
        records = cursor.fetchmany(number)
        for row in records:
            print(row)
    except (Exception, psycopg2.Error) as error:
        print("Error while fetching data from PostgreSQL",error)
    finally:
        if(connection):
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed.")


def selectOneExample(id):
    try:
        connection = psycopg2.connect(
            host="localhost",
            user="postgres",
            password="postgres",
            database="mydatabase"
        )
        connection.set_session(autocommit=True)
        cursor = connection.cursor()
        sqlQuery = "SELECT * FROM tb_accounts WHERE id = %s" % (id)
        cursor.execute(sqlQuery)
        print("Selecting one row from tb_accounts table using cursor.fetchone")
        row = cursor.fetchone() # retorna tuplas
        print(row)

    except (Exception, psycopg2.Error) as error:
        print("Error while fetching data from PostgreSQL", error)
    finally:
        # closing database connection.
        if connection:
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")

if __name__ == '__main__':
    # selectAllExample()
    selectOneExample(2)
    selectManyExample(2)