package service;

import dao.DAOFactory;
import objects.User;

public class AddUserCommand implements Command {
	 User user;

	public AddUserCommand(User user) {
	this.user = user;
	}

	@Override
	public void execute(){
		DAOFactory.getDAO("User").insert(user);
	}
}
