package service;

import dao.DAOFactory;
import objects.Task;

public class AddTaskToUserCommand{
	Task task;

	public AddTaskToUserCommand(Task task) {
		this.task = task;
	}

	public void execute() {
		DAOFactory.getDAO("Task").insert(this.task);
	}

}
