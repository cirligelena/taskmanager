package service;

import java.sql.SQLException;
import dao.DAOFactory;
import objects.Task;

public class AddTaskToUserCommand{
	Task task;

	public AddTaskToUserCommand(Task task) {
		this.task = task;
	}

	public void execute() throws ClassNotFoundException, SQLException {
		DAOFactory.getDAO("Task").insert(this.task);
	}

}
