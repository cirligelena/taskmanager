package commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import taskmanagerApp.MyAplication;
/**
* Creates a necessary Command instance depending on introduced String parameter 
* @param one of the following: "createUser", "showAllUsers", "addTask", "showAllTasks" 
*/
public class CommandFactory {
	private static final Logger logger = LogManager.getLogger(MyAplication.class);
	public Command getCommand (String [] args) {

		String method = args[0];

		if (method.equals("createUser")) {
			return new AddUserCommand(args);
			
		} else if (method.equals("showAllUsers")) {
			return new ShowAllUsersCommand();
		} else if (method.equals("addTask")) {
			return new AddTaskToUserCommand(args);
			
		}else if (method.equals("showAllTasks")) {
			return new ShowAllTasksCommand(); 
		} else
			logger.error("This command does not exist");
			return null; 

	}

}
