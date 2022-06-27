
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import objects.User;

class UserDAOImpl implements UserDAO<User> {
	
	UserDAOImpl(){
		
	};
	private static final Logger logger = LogManager.getLogger(DBConnector.class);

	public void insert(User user) {
		DBConnector.getInstance();
		Connection conn = DBConnector.getConnection();
		String insert = "insert into users (first_name, last_name, user_name) values(?, ?, ?)";
		PreparedStatement prepInsert;			
			try {
				prepInsert = conn.prepareStatement(insert);
				prepInsert.setString(1, user.getFirstName());
				prepInsert.setString(2, user.getLastName());
				prepInsert.setString(3, user.getUserName());
				prepInsert.execute();
			} catch (SQLException e) {
			
				logger.error( "Error while executing SQL statement ");
				e.printStackTrace();
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
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setUserName(resultSet.getString(4));
				System.out.println("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName() + " Username: " + user.getUserName());

			}
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ");
		}
	}

	

	}
