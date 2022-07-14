package service;

import annotations.SendMail;
import dao.TaskDAO;
import dao.TaskDAOImpl;
import entity.Task;

public class TaskServiceImpl implements TaskService {
	private TaskDAO<Task> taskDAOImpl = new TaskDAOImpl();

	public TaskServiceImpl() {
	}

	@SendMail
	@Override
	public void addTask(String taskTitle, String taskDescription) {
		taskDAOImpl.insert(new Task(taskTitle, taskDescription));
	}

	@Override
	public void showAllTasks() {
		taskDAOImpl.select();

	}

}
