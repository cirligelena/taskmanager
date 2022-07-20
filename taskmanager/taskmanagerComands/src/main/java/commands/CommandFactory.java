package commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import taskmanagerApp.MyAplication;

/**
 * 
 * Creates a necessary Command instance depending on introduced String parameter
 * 
 * @param one of the following: "createUser", "showAllUsers", "addTask",
 *            "showAllTasks"
 */

public class CommandFactory {
	private static final Logger logger = LogManager.getLogger(MyAplication.class);

	public Command getCommand(String[] args) {
		Command command = null;
		String method = args[0];
		switch (method) {
		case "createUser":
			command = new AddUserCommand(args[1], args[2], args[3]);
			break;
		case "showAllUsers":
			command = new ShowAllUsersCommand();
			break;
		case "addTask":
			command = new AddTaskCommand(args[1], args[2]);
			break;
		case "showAllTasks":
			command = new ShowAllTasksCommand();
			break;
		case "addTasktoUser":
			command = new AddTaskToUserCommand(args[1], args[2], args[3]);
			break;
		case "addUserAndTask":
			command = new AddUserAndTaskCommand(args[1], args[2], args[3], args[4], args[5]);
			break;
		case "assignTask":
			command = new AssignTaskToUserCommand(args[1], args[2]);
			break;
		case "showUsersTasks":
			command = new ShowUsersTasksCommand(args[1]);
			break;
		default:
			logger.error("This command does not exist");
		}
		return command;

	}
}
