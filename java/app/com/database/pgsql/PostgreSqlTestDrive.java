package com.database.pgsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class PostgreSqlTestDrive {
	public static void main(String[] args) {
		try {
			selectExample();
			
			AccountModel acct = new AccountModel("Mateus","Cardozo","mateusvieiracardozo@gmail.com");
			// insertExample(acct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertExample(AccountModel acct) throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mydatabase","postgres","postgres");
			
			String SQL_INSERT = "INSERT INTO tb_accounts (first_name, second_name, email) VALUES (?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, acct.getFirstName());
			stmt.setString(2, acct.getSecondName());
			stmt.setString(3, acct.getEmail());
			
			int numRows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public static void selectExample() throws SQLException {
		
		Connection conn = null;
		List<AccountModel> accounts = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mydatabase", "postgres", "postgres");
			String SQL_SELECT = "SELECT * FROM tb_accounts";
			PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String secondName = rs.getString("second_name");
				String email = rs.getString("email");
				AccountModel acct = new AccountModel(id, firstName, secondName, email);
				accounts.add(acct);
			}
			
			// accounts.stream().forEach( (a) -> System.out.println(a) );
			List<AccountModel> sortedAccounts = accounts.stream().sorted(Comparator.comparing(AccountModel::getName)).collect(Collectors.toList());
			//List<AccountModel> sortedAccounts = accounts.stream().sorted(new AccountModelComparatorSortByEmail()).collect(Collectors.toList());
			for(AccountModel acct: sortedAccounts) {
				System.out.println(acct);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
