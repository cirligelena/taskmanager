package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class DAOAbstract<T> implements DAO<T> {
	private static final Logger logger = LogManager.getLogger(DAOAbstract.class);
	private Connection conn;

	public void select() {
		ResultSet resultSet;
		try {
			resultSet = getSelectAllStatement().executeQuery();
			while (resultSet.next()) {
				T t = createObject(resultSet);
				System.out.println(t);
			}
			closeDBConnection();
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ", e);
		}

	}

	public int insert(T t) {
		int result;
		try {
			result = getInsertStatement(t).executeUpdate();
			logger.info("Data has been written succesfully ");
			closeDBConnection();
		} catch (SQLException e) {
			logger.error("Error while executing SQL statement ", e);
			result = 0;
		}
		return result;
	}

	protected abstract PreparedStatement getSelectAllStatement() throws SQLException;

	protected abstract PreparedStatement getInsertStatement(T t) throws SQLException;

	protected abstract T createObject(ResultSet resultSet) throws SQLException;

	public Connection getDBConnection() {
		DBConnector.getInstance();
		conn = DBConnector.getConnection();
		return conn;
	}

	public void closeDBConnection() throws SQLException {
		conn.close();
	}

}
