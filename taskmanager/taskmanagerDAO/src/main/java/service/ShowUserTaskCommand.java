package service;

import java.sql.SQLException;
import dao.DAOFactory;

public class ShowUserTaskCommand {
	

	public void execute() throws ClassNotFoundException, SQLException {
		DAOFactory.getDAO("Task").select();
	}

}
