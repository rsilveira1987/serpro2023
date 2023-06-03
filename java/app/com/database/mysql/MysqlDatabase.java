/*
 * ***** MYSQL Schema *****
 * 
 * CREATE TABLE `tb_accounts` (
 *      `id` int(11) NOT NULL AUTO_INCREMENT,
 *      `first_name` varchar(150) NOT NULL,
 *      `second_name` varchar(150) DEFAULT NULL,
 *      `email` varchar(150) NOT NULL,
 *      PRIMARY KEY (`id`),
 *      UNIQUE KEY `email` (`email`)
 * ) ENGINE = InnoDB; 
 * 
 * Como obter uma conexao ao MYSQL (DSN)
 * Connection conn=DriverManager.getConnection("jdbc:mysql://<server_addr>:3306/mydatabasename?characterEncoding=utf8","<user>","<password>");
 * 
 * Statement x PreparedStatement
 * 	- Statement is suitable for executing DDL commands – CREATE, drop, alter and truncate ( slower )
 *  - PreparedStatement is suitable for executing DML commands – SELECT, INSERT, UPDATE and DELETE ( faster )
 * 
 */
package com.database.mysql;

import java.sql.*;  

public class MysqlDatabase {
    
    public static void createExample(String firstName, String secondName, String email) {  
                
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");  
            
            // create the mysql insert preparedstatement
            String query="INSERT INTO tb_accounts (first_name, second_name, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, firstName);
            preparedStmt.setString (2, secondName);
            preparedStmt.setString (3, email);
                    
            // execute the preparedstatement
            int numRows = preparedStmt.executeUpdate();

            // close connection
            conn.close();
                
        } catch(SQLException e){
            System.err.println("Got a SQL exception!");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	System.err.println("Got a ClassNotFound exception!");
        	System.err.println(e.getMessage());
        	e.printStackTrace();
		}
    }
    
    public static void retrieveExample(int id) {
    	    	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");
			
			String query = "SELECT * FROM tb_accounts WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("first_name");
				String secondName = rs.getString("second_name");
				String email = rs.getString("email");
				System.out.format("%s, %s, %s, %s\n", id, firstName, secondName, email);
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Got a SQL exception!");
            System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Got a ClassNotFound exception!");
        	System.err.println(e.getMessage());
			e.printStackTrace();
		}
    	
    }

    public static void retrieveAllExample(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");  
            
            // PreparedStatement preparedStmt = conn.prepareStatement(query);
            // ResultSet rs = preparedStmt.executeQuery(query);  
            
            // create the java statement
            Statement stmt = conn.createStatement();
            String query="SELECT * FROM tb_accounts ORDER BY first_name,second_name";            
            ResultSet rs = stmt.executeQuery(query); // execute the query, and get a java resultset
            
            while(rs.next()) {
                int id=rs.getInt("id");
                String firstName=rs.getString("first_name");
                String secondName=rs.getString("second_name");
                String email=rs.getString("email");

                System.out.format("%s, %s, %s, %s\n", id, firstName, secondName, email);
            }
                
            // close connection
            conn.close(); 
        } catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static boolean updateExample(int id, String firstName, String secondName, String email){  
                
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");  
            
            // create the mysql insert preparedstatement
            String query="UPDATE tb_accounts SET first_name = ?, second_name = ?, email = ? WHERE id = ?";
            PreparedStatement preparedStmt=conn.prepareStatement(query);
            preparedStmt.setString (1, firstName);
            preparedStmt.setString (2, secondName);
            preparedStmt.setString (3, email);
            preparedStmt.setInt (4, id);
        
            // execute the preparedstatement
            int numRows = preparedStmt.executeUpdate();

            // close connection
            conn.close();  
            
            return (numRows == 1);
                
        } catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            
        }
        return false;
    }
    
    public static boolean deleteExample(int id){  
                
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");  
            
            // create the mysql insert preparedstatement
            String query="DELETE FROM tb_accounts WHERE id = ?";
            PreparedStatement preparedStmt=conn.prepareStatement(query);
            preparedStmt.setInt (1, id);
        
            // execute the preparedstatement
            int numRows = preparedStmt.executeUpdate();

            // close connection
            conn.close();                  
            
            return (numRows == 1);
            
        } catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return false;        
    }
}  