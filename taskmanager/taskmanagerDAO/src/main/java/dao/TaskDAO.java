package dao;

/**
 * extends DAO contains 1 additional method "assignTask" that will be
 * implemented in the class TaskDAOImpl
 */
public interface TaskDAO<Task> extends DAO<Task> {
	/**
	 * This method will be used to assign an existing Task to a user that already
	 * exists
	 * 
	 * @param userName  of user to whom the task will be assigned
	 * @param taskTitle of task that should be assigned
	 */
	void assignTask(String userName, String taskTitle);
}