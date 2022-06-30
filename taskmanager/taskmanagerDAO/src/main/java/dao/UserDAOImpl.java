
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import entity.User;

public class UserDAOImpl extends DAOAbstract<User> {

	private static final Logger logger = LogManager.getLogger(DBConnector.class);

	public int insert(User user) {
		try {
			PreparedStatement prepstatement = getInsertStatement(user);
			prepstatement.setString(1, user.getFirstName());
			prepstatement.setString(2, user.getLastName());
			prepstatement.setString(3, user.getUserName());
			prepstatement.execute();
			logger.info("User was added");
			closeDBConnection();
		} catch (SQLException e) {

			logger.error("Error while executing SQL statement ", e);
		}
		return 0;
	}

	public void select() {
		try {
			ResultSet resultSet = getSelectAllStatement().executeQuery();
			while (resultSet.next()) {
				User user = createObject(resultSet);
				System.out.println("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName()
						+ " Username: " + user.getUserName());
			}
			closeDBConnection();
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ", e);
		}
	}

	@Override
	protected PreparedStatement getSelectAllStatement() throws SQLException {
		String query = "select*from users";
		PreparedStatement prepstatement = getDBConnection().prepareStatement(query);
		return prepstatement;
	}

	@Override
	protected PreparedStatement getInsertStatement(User user) throws SQLException {
		String query = "insert into users (first_name, last_name, user_name) values(?, ?, ?)";
		PreparedStatement prepstatement = getDBConnection().prepareStatement(query);
		return prepstatement;
	}

	@Override
	protected User createObject(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setFirstName(resultSet.getString(2));
		user.setLastName(resultSet.getString(3));
		user.setUserName(resultSet.getString(4));
		return user;
	}

}
