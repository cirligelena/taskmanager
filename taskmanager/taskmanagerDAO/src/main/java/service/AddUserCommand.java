package service;

import java.sql.SQLException;
import dao.DAOFactory;
import objects.User;

public class AddUserCommand implements Command {
	 User user;

	public AddUserCommand(User user) {
	this.user = user;
	}

	@Override
	public void execute() throws ClassNotFoundException, SQLException {
		DAOFactory.getDAO("User").insert(user);
	}
}
