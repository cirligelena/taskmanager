package commands;

import objects.Task;
import service.TaskDAOService;

public class AddTaskToUserCommand implements Command{
	String []args;
	String un = args[1];
	String tt = args[2];
	String td = args[3];
	String gn = args[4];
	Task task = new Task(un, tt, td, gn);
	@SuppressWarnings("rawtypes")
	TaskDAOService taskDAOService = new TaskDAOService();
	
	AddTaskToUserCommand(String []args){
		this.args = args;
	}
	

	@Override
	public void execute(){
		taskDAOService.createDao().insert(task);
	}
}
