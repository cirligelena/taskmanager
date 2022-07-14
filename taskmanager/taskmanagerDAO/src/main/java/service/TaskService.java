package service;

/**
 * An auxiliary class used to get a necessary TaskDAO method. Was created in
 * order to restrict direct access from a command to DAO
 */
public interface TaskService {
	public void addTask(String userName, String taskTitle, String taskDescription, String groupName);

	public void showAllTasks();

}
