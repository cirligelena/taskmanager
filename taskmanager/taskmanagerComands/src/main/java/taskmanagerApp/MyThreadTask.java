package taskmanagerApp;

import commands.Command;

public class MyThreadTask implements Runnable {
	private Command command;

	public MyThreadTask(Command command) {
		this.command = command;
	}

	@Override
	public void run() {
		command.execute();
	}
}
