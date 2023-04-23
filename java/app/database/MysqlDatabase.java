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
 */
package database;

import java.sql.*;  

public class MysqlDatabase {
    
    public static void insertExample(String firstName, String secondName, String email){  
                
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
            preparedStmt.execute();

            // close connection
            conn.close();
                
        } catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static void selectExample(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");  
            
            Statement stmt=conn.createStatement();
            String query="SELECT * FROM tb_accounts";
            ResultSet rs=stmt.executeQuery(query);  
            
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

    public static boolean deleteExample(int id){  
        
        int numRows=0;      
        
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8","root","root");  
            
            // create the mysql insert preparedstatement
            String query="DELETE FROM tb_accounts WHERE id = ?";
            PreparedStatement preparedStmt=conn.prepareStatement(query);
            preparedStmt.setInt (1, id);
        
            // execute the preparedstatement
            numRows = preparedStmt.executeUpdate();

            // close connection
            conn.close();  
                
        } catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return numRows==1;
    }

    public static boolean updateExample(int id, String firstName, String secondName, String email){  
        
        int numRows=0;      
        
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
            numRows = preparedStmt.executeUpdate();

            // close connection
            conn.close();  
                
        } catch(Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return numRows==1;
    }
}  