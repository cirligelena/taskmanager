package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAOAbstract<T> implements DAO<T> {
	Connection conn;

	public void select() throws SQLException {
		ResultSet resultSet = getSelectAllStatement().executeQuery();
		while (resultSet.next()) {
			T t = createObject(resultSet);
			System.out.println(t);
		}
	}

	public int insert(T t) throws SQLException {
		return getInsertStatement(t).executeUpdate();
	}

	protected abstract PreparedStatement getSelectAllStatement() throws SQLException;

	protected abstract PreparedStatement getInsertStatement(T t) throws SQLException;

	protected abstract T createObject(ResultSet resultSet) throws SQLException;

	Connection getDBConnection() {
		DBConnector.getInstance();
		conn = DBConnector.getConnection();
		return conn;
	}

	void closeDBConnection() throws SQLException {
		conn.close();
	}

}
