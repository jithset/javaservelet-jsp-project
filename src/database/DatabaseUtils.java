package database;


import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.Credentials;

import java.sql.Connection;


public class DatabaseUtils implements DatabaseInterface {
	private String getConnectionUrl() {
		String connectionUrl = "jdbc:mysql://"+Credentials.HOST_NAME+"/"+Credentials.SCHEMA_NAME+"?user="+Credentials.USER_NAME+"&password="+Credentials.USER_PASSWORD;
		return connectionUrl;
	}
	@Override
	public Connection createConnection() {
		Connection connection = null;
		  String className = Credentials.DB_DRIVER;
		try {
			  Class<?> driverObject = Class.forName(className);
			connection = (Connection) DriverManager.getConnection(getConnectionUrl());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
//				System.out.println("Connection closing!");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void driverSetUp() {
		StringBuffer output  = new StringBuffer();
		  try {
			  String className = Credentials.DB_DRIVER;
			  Class<?> driverObject = Class.forName(className);
			  output.append("Driver : "+driverObject+"\n");
			  output.append("Driver Installation Successful");
			  //JOptionPane.showMessageDialog(null, output);
			  System.out.println(output);
		    } catch (Exception e) {
		    	output  = new StringBuffer();
		    	output.append("Driver Installation FAILED\n");
		    	JOptionPane.showMessageDialog(null, output);
		    	System.out.println("Failed: Driver Error: " + e.getMessage());
		  }
	}

}
