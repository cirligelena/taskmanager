package dao;

import java.sql.SQLException;

public interface DAO<T> {
	void insert(T t) throws ClassNotFoundException, SQLException;

	void select() throws ClassNotFoundException, SQLException;

}
