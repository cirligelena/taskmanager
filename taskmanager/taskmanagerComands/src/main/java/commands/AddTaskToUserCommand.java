package commands;

import service.UserService;
import service.UserServiceImpl;

public class AddTaskToUserCommand implements Command {
	private UserService userService;
	private String userName;
	private String taskTitle;
	private String taskDescription;

	AddTaskToUserCommand(String userName, String taskTitle, String taskDescription) {
		this.userName = userName;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		userService = new UserServiceImpl();
	}

	@Override
	public void execute() {
		userService.addTasktoUser(userName, taskTitle, taskDescription);
	}
}
