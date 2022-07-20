package taskmanagerApp;

import commands.Command;

public class MyThreadTask implements Runnable {
	Command command;

	MyThreadTask(Command command) {
		this.command = command;
	}

	@Override
	public void run() {
		command.execute();
	}
}
