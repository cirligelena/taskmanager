package commands;

import service.UserServiceImpl;

public class AddUserCommand implements Command {
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private String firstName;
	private String lastName;
	private String userName;

	AddUserCommand(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	@Override
	public void execute() {
		userServiceImpl.addUser(firstName, lastName, userName);
	}
}
