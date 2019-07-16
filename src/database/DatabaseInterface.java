package database;

import java.sql.Connection;

public interface DatabaseInterface {
	public Connection createConnection();
	public void closeConnection(Connection connection);
	public void driverSetUp();
}
