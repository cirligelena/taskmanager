package taskmanagerApp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Command;

public class CommandExecutor {
	static CommandChooser chooser;
	String [] args;
	
	private final List<Command> commands = new ArrayList<>();
	
	public void executeCommand (String string) throws ClassNotFoundException, SQLException{	
		commands.add(chooser.getCommand(args));
		chooser.getCommand(args).execute();
	}
	
}
