package service;

import dao.TaskDAO;
import dao.TaskDAOImpl;
import entity.Task;

public class TaskServiceImpl implements TaskService {
	private TaskDAO<Task> taskDAOImpl = new TaskDAOImpl();

	public TaskServiceImpl() {
	}

	@Override
	public void addTask(String userName, String taskTitle, String taskDescription, String groupName) {
		taskDAOImpl.insert(new Task(userName, taskTitle, taskDescription, groupName));
	}

	@Override
	public void showAllTasks() {
		taskDAOImpl.select();

	}
}
