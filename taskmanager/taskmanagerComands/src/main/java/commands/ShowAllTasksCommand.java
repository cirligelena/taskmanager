package commands;

import service.TaskDAOService;

public class ShowAllTasksCommand  implements Command{
	
	
	@SuppressWarnings("rawtypes")
	public void execute(){
		new TaskDAOService().createDao().select();
	}
		
	}

