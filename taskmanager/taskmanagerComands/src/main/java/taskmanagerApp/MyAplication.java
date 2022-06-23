package taskmanagerApp;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import objects.Task;
import objects.User;



public class MyAplication {
	static CommandExecutor commandExecutor = new CommandExecutor();
	
	private static final Logger logger = LogManager.getLogger(MyAplication.class);
	 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String method = args[0];

		if (method.equals("createUser")) {
			String fn = args[1];
			String ln = args[2];
			String un = args[3];
			User user = new User(fn, ln, un);
			commandExecutor.executeCommand(method, user);
			logger.info("User was created succesfully!");
		} else if (method.equals("showAllUsers")) {
			commandExecutor.executeCommand(method);
		} else if (method.equals("addTask")) {
			String un = args[1];
			String tt = args[2];
			String td = args[3];
			String gn = args[4];
			Task task = new Task(un, tt, td, gn);
			commandExecutor.executeCommand(method, task);
			logger.info("Task was added");
		} else if (method.equals("showTasks")) {
			commandExecutor.executeCommand(method);
		} else
			logger.error("Such command doesn't exist");

	}
}
