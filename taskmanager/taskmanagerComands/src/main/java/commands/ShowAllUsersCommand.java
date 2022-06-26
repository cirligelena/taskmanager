package commands;

import service.UserDAOService;


public class ShowAllUsersCommand implements Command{
	@SuppressWarnings("rawtypes")
	UserDAOService userDAOService = new UserDAOService();
	

	public void execute(){
		 userDAOService.createDao().select();
	}
	
}
