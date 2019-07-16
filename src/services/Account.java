package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import database.DatabaseUtils;
import utils.Utils;

public class Account {
	public int createAccount(String username, String password) {
		DatabaseUtils dbUtils = new DatabaseUtils();
		dbUtils.driverSetUp();
		Connection connection = dbUtils.createConnection();
		if (connection != null ) {
			String query = "INSERT INTO account (username,password) VALUES(?,?);";
					
			try {
				PreparedStatement stmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.executeUpdate();
				ResultSet res = stmt.getGeneratedKeys();
				if (res.next()) {
					return res.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbUtils.closeConnection(connection);
			}	
		} else {
			System.out.println("Coonnection null");
		}
		return 0;
	}
	
	public boolean loginUser(String username, String password) {
		String query = "SELECT * FROM account WHERE username=?";
		DatabaseUtils dbUtils = new DatabaseUtils();
		Connection connection = dbUtils.createConnection();
		try {
			PreparedStatement loginStmt = connection.prepareStatement(query);
			loginStmt.setString(1, username);
			ResultSet resultSet = loginStmt.executeQuery();
			if (resultSet.next()) {
				if (password.equals(resultSet.getString(3))) {
					return true;
				}
			} 
		} catch (SQLException e) {
			System.out.println("Login User Exception");
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}		
		return false;
	}
}
