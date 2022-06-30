package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import helper.Helper;

/**
 * This class is used for creating a MYSQL DBConnection. DB connection is
 * creating using a Singleton design pattern. The values of environment
 * variables (username, password and URL) are stored in a distinct file
 * config.properties. In order to use this App on other computer, please create
 * a config.properties file.
 * 
 * @author ecirlig
 *
 */

class DBConnector {
	private static DBConnector instance;
	private static Connection connection;
	private Helper helper = new Helper();
	private final String USERNAME = helper.readProperty("USERNAME");
	private final String PASSWORD = helper.readProperty("PASSWORD");
	private final String URL = helper.readProperty("URL");

	private static final Logger logger = LogManager.getLogger(DBConnector.class);

	private DBConnector() {

		try {
			DBConnector.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			logger.error("Connection to DataBase failed");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static DBConnector getInstance() {
		if (instance == null) {
			instance = new DBConnector();
		} else
			try {
				if (DBConnector.getConnection().isClosed()) {
					if (instance == null) {
						instance = new DBConnector();
					}
				}
			} catch (SQLException e) {
				logger.error("Connection to DataBase failed");
			}
		return instance;

	}
}
