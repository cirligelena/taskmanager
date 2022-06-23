package taskmanagerApp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Command;

public class CommandExecutor {
	CommandFactory factory;
	
	private final List<Command> commands = new ArrayList<>();
	
	public void executeCommand (String type) throws ClassNotFoundException, SQLException {
		commands.add(factory.getCommand(type));
		factory.getCommand(type).execute();
	}
	public void executeCommand (String type, Object object) throws ClassNotFoundException, SQLException {
		commands.add(factory.getCommand(type));
		factory.getCommand(type).execute();
	}
}
