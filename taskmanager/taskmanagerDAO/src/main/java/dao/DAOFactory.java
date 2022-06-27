package dao;
/**
* Creates a necessary DAO instance for introduced String argument (for "User" a UserDAO will be created,   
* for "Task" a TaskDAO will be created)
*/
public class DAOFactory {
	@SuppressWarnings("unchecked")
	public static <T> DAO <T> getDAO(String type) {
		if (type.equals("User")) {
			return  (DAO<T>) new UserDAOImpl();
		} else if (type.equals("Task")) {
			return (DAO<T>) new TaskDAOImpl();
		} else
			return null;
	}
}