package commands;

import service.UserServiceImpl;

public class AddUserAndTaskCommand implements Command {
	private UserServiceImpl userService;
	private String firstName;
	private String lastName;
	private String userName;

	private String taskTitle;
	private String taskDescription;

	AddUserAndTaskCommand(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		userService = new UserServiceImpl();

	}

	@Override
	public void execute() {
		userService.addUserAndTask(firstName, lastName, userName, taskTitle, taskDescription);
	}
}
