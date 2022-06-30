package commands;

import service.UserService;
import service.UserServiceImpl;

public class ShowAllUsersCommand implements Command {
	private UserService userServiceImpl = new UserServiceImpl();

	public void execute() {
		userServiceImpl.showAllUsers();
	}

}
