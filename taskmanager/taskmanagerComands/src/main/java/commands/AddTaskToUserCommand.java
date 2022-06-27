package commands;

import objects.Task;
import service.TaskDAOService;

public class AddTaskToUserCommand implements Command{
	private String []args;
	
	AddTaskToUserCommand(String []args){
		this.args = args;
	}
	public String [] getArgs() {
		return args;
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(){
		String[] args = getArgs();
		Task task = new Task(args[1], args[2], args[3], args[4]);
		new TaskDAOService().createDao().insert(task);
	}
}
