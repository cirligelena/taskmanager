package commands;

import service.UserService;
import service.UserServiceImpl;

public class ShowUsersTasksCommand implements Command {
	private UserService userService;
	private String userName;

	public ShowUsersTasksCommand(String userName) {

		this.userName = userName;
		userService = new UserServiceImpl();

	}

	@Override
	public void execute() {
		userService.showUsersTasks(userName);
	}
}
