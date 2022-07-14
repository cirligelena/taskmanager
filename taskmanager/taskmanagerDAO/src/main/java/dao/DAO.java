package dao;

/**
 * Contains a method "select" without any parameters (implemented in next
 * classes as select all from a table) and a generic method "insert"
 */
public interface DAO<T> {
	/**
	 * This method will be used to select all data from a table
	 */
	void select();

	/**
	 * This generic method will be used to insert new data in a table
	 * 
	 * @param t represents the entity (Task/User) that should be inserted in the
	 *          database
	 */
	void insert(T t);

}
