package dao;

public class DAOFactory {
	@SuppressWarnings("unchecked")
	public static <T> DAO<T> getDAO(String type) {
		if (type.equals("User")) {
			return (DAO<T>) new UserDAO();
		} else if (type.equals("Task")) {
			return (DAO<T>) new TaskDAO();
		} else
			return null;
	}
}