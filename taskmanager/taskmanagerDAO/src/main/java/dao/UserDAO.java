
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import objects.User;

class UserDAO implements DAO<User> {
	private static final Logger logger = LogManager.getLogger(DBConnector.class);

	public void insert(User user) {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		String insert = "insert into users (first_name, last_name, user_name) values(?, ?, ?)";
		PreparedStatement prepInsert;
		try {
			prepInsert = conn.prepareStatement(insert);
			prepInsert.setString(1, user.getFirst_name());
			prepInsert.setString(2, user.getLast_name());
			prepInsert.setString(3, user.getUser_name());
			prepInsert.execute();
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ");
		}
	}

	public void select() {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select*from users");
			while (resultSet.next()) {
				User user = new User();
				user.setFirst_name(resultSet.getString(1));
				user.setLast_name(resultSet.getString(2));
				user.setUser_name(resultSet.getString(3));
				System.out.println(user);

			}
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ");
		}
	}
}
