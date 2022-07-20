package commands;

import service.TaskService;
import service.TaskServiceImpl;

public class AssignTaskToUserCommand implements Command {
	private TaskService taskService;

	private String userName;

	private String taskTitle;

	public AssignTaskToUserCommand(String userName, String taskTitle) {
		this.userName = userName;
		this.taskTitle = taskTitle;

		taskService = new TaskServiceImpl();

	}

	@Override
	public void execute() {
		taskService.assignTasktoUser(userName, taskTitle);
	}
}
