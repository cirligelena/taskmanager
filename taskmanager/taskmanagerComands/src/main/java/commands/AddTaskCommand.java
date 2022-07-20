package commands;

import service.TaskService;
import service.TaskServiceImpl;

public class AddTaskCommand implements Command {
	private TaskService taskService;
	private String taskTitle;
	private String taskDescription;

	public AddTaskCommand(String taskTitle, String taskDescription) {
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		taskService = new TaskServiceImpl();
	}

	public void execute() {
		taskService.addTask(taskTitle, taskDescription);
	}
}
