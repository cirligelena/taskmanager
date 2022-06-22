package dao;

import java.sql.*;

class DBConnector {
	private static DBConnector instance;

	private static Connection connection;
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String URL = "jdbc:mysql://localhost:3306/taskmanager";

	private DBConnector() throws SQLException {
		DBConnector.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}

	public static Connection getConnection() {
		return connection;
	}

	public static DBConnector getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnector();
		} else if (DBConnector.getConnection().isClosed()) {
			if (instance == null) {
				instance = new DBConnector();
			}
		}
		return instance;

	}
}
