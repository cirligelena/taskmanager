package taskmanagerApp;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import objects.Task;
import objects.User;



public class MyAplication {
	private static final Logger logger = LogManager.getLogger(MyAplication.class);
	 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String method = args[0];

		if (method.equals("createUser")) {
			String fn = args[1];
			String ln = args[2];
			String un = args[3];
			User user = new User(fn, ln, un);
			CommandFactory.getCommand(method, user).execute();
			logger.info("User was created succesfully!");
		} else if (method.equals("showAllUsers")) {
			CommandFactory.getCommand(method).execute();
		} else if (method.equals("addTask")) {
			String un = args[1];
			String tt = args[2];
			String td = args[3];
			String gn = args[4];
			Task task = new Task(un, tt, td, gn);
			CommandFactory.getCommand(method, task).execute();
			logger.info("Task was added");
		} else if (method.equals("showTasks")) {
			CommandFactory.getCommand(method).execute();
		} else
			logger.error("Such command doesn't exist");

	}
}
