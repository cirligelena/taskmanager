package service;

/**
 * An auxiliary class used to get a necessary UserDAO method Was created in
 * order to restrict direct access from a command to DAO
 */
public interface UserService {
	/**
	 * This method will be used to save new task into database
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 */
	public void addUser(String firstName, String lastName, String userName);

	/**
	 * This method will be used to show all users from the table
	 */

	public void showAllUsers();

	/**
	 * This method will be used to create and save a new Task and assign it to a
	 * user that already exists
	 * 
	 * @param username
	 * @param taskTitle
	 * @param taskDescription
	 */

	public void addTasktoUser(String username, String taskTitle, String taskDescription);

	/**
	 * This method will be used to create and save a new user with a new task
	 * assigned
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param taskTitle
	 * @param taskDescription
	 */

	public void addUserAndTask(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription);

	public void showUsersTasks(String userName);
}