package dao;

import entity.Task;
import entity.User;

/**
 * extends DAO and contains 3 additional methods "insertTask",
 * "selectUsersTasks" and "insertUserAndTask" that will be implemented in the
 * class UserDAOImpl
 * 
 * @param <T>
 */
public interface UserDAO<T> extends DAO<T> {
	/**
	 * This method will be used to assign a new Task to a user that already exists
	 * 
	 * @param username of user to whom the task will be assigned
	 * @param task     a new Task entity that will be saved into database
	 */
	void insertTask(String username, Task task);

	/**
	 * This method will be used to introduce a new user with a new task assigned
	 * 
	 * @param user a new User entity that will be saved into database
	 * @param task a new Task entity that will be saved into database
	 */

	void insertUserAndTask(User user, Task Task);

	/**
	 * This method will be used to show user's tasks assigned
	 * 
	 * @param userName
	 */

	void selectUsersTasks(String userName);
}
