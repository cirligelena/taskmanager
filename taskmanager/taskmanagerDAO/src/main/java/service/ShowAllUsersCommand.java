package service;


import dao.DAOFactory;

public class ShowAllUsersCommand {
	

	public void execute(){
		DAOFactory.getDAO("User").select();
	}

}
