package taskmanagerApp;

import objects.Task;
import objects.User;
import service.Command;




public class CommandFactory {
	   
   
	public Command getCommand(String type) {
		 if (type.equals("showAllUsers")) {
			return (Command) new service.ShowAllUsersCommand();
		}else if (type.equals("showTasks")) {
			return (Command) new service.ShowUserTaskCommand(); 
		}else
			return null;
	}
	
	public Command getCommand(String type, Object object) {
		if (type.equals("createUser")) {
			return (Command)new service.AddUserCommand((User) object);
		}else if (object.equals("showTasks")) {
			return (Command) new service.AddTaskToUserCommand((Task) object); 
		}else
			return null;
	}
	
}
