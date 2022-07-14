
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDAOImpl extends DAOAbstract<User> implements UserDAO<User> {

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
		prepstatement.setString(1, user.getFirstName());
		prepstatement.setString(2, user.getLastName());
		prepstatement.setString(3, user.getUserName());
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
