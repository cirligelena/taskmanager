package taskmanagerApp;

import commands.CommandFactory;

public class MyAplication {
	static CommandFactory commandFactory = new CommandFactory();

	public static void main(String[] args){
		
		commandFactory.getCommand(args).execute();

	}
}