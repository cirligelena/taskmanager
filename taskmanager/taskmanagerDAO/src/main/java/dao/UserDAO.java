
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.User;

class UserDAO implements DAO<User> {

	public void insert(User user) throws ClassNotFoundException, SQLException {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		String insert = "insert into users (first_name, last_name, user_name) values(?, ?, ?)";
		PreparedStatement prepInsert = conn.prepareStatement(insert);
		prepInsert.setString(1, user.getFirst_name());
		prepInsert.setString(2, user.getLast_name());
		prepInsert.setString(3, user.getUser_name());
		prepInsert.execute();
	}

	public void select() throws ClassNotFoundException, SQLException {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select*from users");
		while (resultSet.next()) {
			User user = new User();
			user.setFirst_name(resultSet.getString(1));
			user.setLast_name(resultSet.getString(2));
			user.setUser_name(resultSet.getString(3));
			System.out.println(user);

		}

	}
}
