package commands;

import service.UserService;
import service.UserServiceImpl;

public class AddUserCommand implements Command {

	private UserService userService;
	private String firstName;
	private String lastName;
	private String userName;

	public AddUserCommand(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		userService = new UserServiceImpl();

	}

	@Override
	public void execute() {
		userService.addUser(firstName, lastName, userName);
	}
}
