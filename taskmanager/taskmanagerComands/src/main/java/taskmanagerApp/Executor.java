package taskmanagerApp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import commands.AddTaskCommand;
import commands.AddUserCommand;
import commands.AssignTaskToUserCommand;
import commands.ShowUsersTasksCommand;

public class Executor {
	private static final Logger logger = LogManager.getLogger(Executor.class);
	private DataFromConsole DataFromConsole;
	private ExecutorService executorService;

	public Executor(DataFromConsole DataFromConsole) {
		this.DataFromConsole = DataFromConsole;
		executorService = Executors.newFixedThreadPool(4);
	}

	public void executeThreadPool() {
		MyThreadTask task1 = new MyThreadTask(new AddUserCommand(DataFromConsole.getFirstName(),
				DataFromConsole.getLastName(), DataFromConsole.getUserName()));
		MyThreadTask task2 = new MyThreadTask(
				new AddTaskCommand(DataFromConsole.getTaskTitle(), DataFromConsole.getTaskDescription()));
		MyThreadTask task3 = new MyThreadTask(
				new AssignTaskToUserCommand(DataFromConsole.getUserName(), DataFromConsole.getTaskTitle()));
		MyThreadTask task4 = new MyThreadTask(new ShowUsersTasksCommand(DataFromConsole.getUserName()));
		Future<?> task1Status = executorService.submit(task1);
		Future<?> task2Status = executorService.submit(task2);
		try {
			task1Status.get();
			task2Status.get();
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e);
		}
		try {
			executorService.submit(task3).get();
			executorService.submit(task4).get();
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e);
		}
		;

		executorService.shutdown();
		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("Finished");
		} catch (InterruptedException e) {
			logger.error(e);
		}
	}
}
