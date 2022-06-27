package taskmanagerApp;

import commands.CommandFactory;
/**
 * The main class of the 
* Starts the program using main method String[] args arguments 
 * @author ecirlig
 *
 */

public class MyAplication {
	static CommandFactory commandFactory = new CommandFactory();

	public static void main(String[] args){
		
		commandFactory.getCommand(args).execute();

	}
}