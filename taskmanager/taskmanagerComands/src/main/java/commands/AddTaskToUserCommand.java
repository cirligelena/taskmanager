package commands;

import service.TaskServiceImpl;

public class AddTaskToUserCommand implements Command {
	private TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
	private String userName;
	private String taskTitle;
	private String taskDescription;
	private String groupName;

	AddTaskToUserCommand(String userName, String taskTitle, String taskDescription, String groupName) {
		this.userName = userName;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.groupName = groupName;
	}

	public void execute() {
		taskServiceImpl.addTask(userName, taskTitle, taskDescription, groupName);
	}
}
