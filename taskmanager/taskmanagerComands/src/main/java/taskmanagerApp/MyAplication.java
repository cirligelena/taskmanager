package taskmanagerApp;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import commands.CommandFactory;

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

		if (args.length == 0) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please introduce the Thirst Name: ");
			String firstName = scanner.nextLine();
			System.out.print("Please introduce the Last Name: ");
			String lastName = scanner.nextLine();
			System.out.print("Please introduce the User Name: ");
			String userName = scanner.nextLine();
			System.out.print("Please introduce the Task Title: ");
			String taskTitle = scanner.nextLine();
			System.out.print("Please introduce the Task Description: ");
			String taskDescription = scanner.nextLine();
			DataFromConsole DataFromConsole = new DataFromConsole(firstName, lastName, userName, taskTitle,
					taskDescription);
			scanner.close();
			new Executor(DataFromConsole).executeThreadPool();
		} else {
			try {
				commandFactory.getCommand(args).execute();
			} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
				logger.error("invalid or missing arguments", e);
			}
		}
	}
}
