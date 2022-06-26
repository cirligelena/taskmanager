package dao;

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