package taskmanagerApp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import service.Command;

public class CommandExecutor {
	private static final Logger logger = LogManager.getLogger(MyAplication.class);
	static CommandChooser chooser;
	String [] args;
	
	private final List<Command> commands = new ArrayList<>();
	
	public void executeCommand (String string){	
		commands.add(chooser.getCommand(args));
		chooser.getCommand(args).execute();
		logger.info("Command was executed succesfully!");
	}
	
}
