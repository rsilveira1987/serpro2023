package com.database.mysql;

public class MysqlDatabaseTestDrive {

	public static void main(String[] args) {
			
		// MysqlDatabase.createExample("Marcela","Vieira","mmvieira87@gmail.com"); // lanca uma classnotfoundexception 
		
		MysqlDatabase.retrieveAllExample();
		System.out.println("---------------------------------");
		MysqlDatabase.deleteExample(6);
		MysqlDatabase.retrieveAllExample();	
		System.out.println("---------------------------------");
		MysqlDatabase.retrieveExample(10);
		
	}

}
