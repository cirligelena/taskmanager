package service;

import dao.DAOFactory;

public class ShowUserTaskCommand {
	

	public void execute(){
		DAOFactory.getDAO("Task").select();
	}

}
