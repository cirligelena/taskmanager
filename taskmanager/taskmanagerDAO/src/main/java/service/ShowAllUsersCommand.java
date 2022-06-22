package service;

import java.sql.SQLException;
import dao.DAOFactory;

public class ShowAllUsersCommand {
	

	public void execute() throws ClassNotFoundException, SQLException {
		DAOFactory.getDAO("User").select();
	}

}
