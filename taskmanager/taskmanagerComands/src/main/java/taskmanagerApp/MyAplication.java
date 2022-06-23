package taskmanagerApp;

import java.sql.SQLException;

public class MyAplication {
	static CommandExecutor executor = new CommandExecutor();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		executor.executeCommand(args[0]);

	}
}