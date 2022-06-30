package dao;

import java.sql.SQLException;

/**
 * Contains a method "select" without any parameters (implemented in next
 * classes as select all from a table)
 * 
 * @author ecirlig
 *
 * 
 */
public interface DAO<T> {
	void select() throws SQLException;

	int insert(T t) throws SQLException;

}
