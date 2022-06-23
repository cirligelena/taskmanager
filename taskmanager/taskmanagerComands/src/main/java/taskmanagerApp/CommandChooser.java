package taskmanagerApp;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import objects.Task;
import objects.User;
import service.Command;

public class CommandChooser {
	private static final Logger logger = LogManager.getLogger(MyAplication.class);
	public Command getCommand (String [] args) {

		String method = args[0];

		if (method.equals("createUser")) {
			String fn = args[1];
			String ln = args[2];
			String un = args[3];
			User user = new User(fn, ln, un);
			logger.info("User was created succesfully!");
			return (Command) new service.AddUserCommand(user);
			
		} else if (method.equals("showAllUsers")) {
			return (Command) new service.ShowAllUsersCommand();
		} else if (method.equals("addTask")) {
			String un = args[1];
			String tt = args[2];
			String td = args[3];
			String gn = args[4];
			Task task = new Task(un, tt, td, gn);
			logger.info("Task was added");
			return (Command) new service.AddTaskToUserCommand(task);
			
		} else if (method.equals("showTasks")) {
			return (Command) new service.ShowUserTaskCommand(); 
		} else
			
			return null; 

	}

}
