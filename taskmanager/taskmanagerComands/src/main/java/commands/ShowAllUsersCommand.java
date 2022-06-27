package commands;

import service.UserDAOService;


public class ShowAllUsersCommand implements Command{
	
	@SuppressWarnings("rawtypes")
	public void execute(){
		new UserDAOService().createDao().select();
	}
	
}
