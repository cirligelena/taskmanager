package taskmanagerApp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import commands.CommandFactory;
/**
 * The main class of the 
* Starts the program using main method String[] args arguments 
 * @author ecirlig
 *
 */

/**
 * The main class of the Starts the program using main method String[] args
 * arguments
 * 
 * @author ecirlig
 *
 */

public class MyAplication {
	private static final Logger logger = LogManager.getLogger(MyAplication.class);
	private static CommandFactory commandFactory = new CommandFactory();

	public static void main(String[] args) {
		try {
			commandFactory.getCommand(args).execute();

		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			logger.error("invalid or missing arguments", e);
		}
	}
}