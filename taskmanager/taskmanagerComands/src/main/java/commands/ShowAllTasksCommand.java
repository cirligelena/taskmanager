package commands;

import service.TaskDAOService;

public class ShowAllTasksCommand  implements Command{
	
		
	@SuppressWarnings("rawtypes")
	TaskDAOService taskDAOService = new TaskDAOService();

	public void execute(){
		 taskDAOService.createDao().select();
	}
		
	}

