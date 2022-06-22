package service;

import java.sql.SQLException;

public interface Command {
	public void execute() throws ClassNotFoundException, SQLException;

}
