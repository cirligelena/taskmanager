package taskmanagerApp;


public class MyAplication {
	static CommandExecutor executor = new CommandExecutor();

	public static void main(String[] args){
		
		executor.executeCommand(args[0]);

	}
}