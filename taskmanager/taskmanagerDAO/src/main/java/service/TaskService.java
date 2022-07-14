package service;

/**
 * An auxiliary class used to get a necessary TaskDAO method. Was created in
 * order to restrict direct access from a command to DAO
 */
public interface TaskService {

	/**
	 * This method will be used to create and save a new task into database
	 * 
	 * @param taskTitle
	 * @param taskDescription
	 */
	public void addTask(String taskTitle, String taskDescription);

	/**
	 * This method will be used to show all tasks from the table
	 */
	public void showAllTasks();

}
