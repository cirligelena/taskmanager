package dao;

/**
 * Contains a method "select" without any parameters (implemented in next
 * classes as select all from a table)
 * 
 * @author ecirlig
 *
 * 
 */
public interface DAO<T> {
	void select();

	int insert(T t);

}
