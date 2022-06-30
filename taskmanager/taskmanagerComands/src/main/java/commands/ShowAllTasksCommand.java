package commands;

import service.TaskServiceImpl;

public class ShowAllTasksCommand implements Command {
	private TaskServiceImpl taskServiceImpl = new TaskServiceImpl();

	public void execute() {
		taskServiceImpl.showAllTasks();
	}

}
