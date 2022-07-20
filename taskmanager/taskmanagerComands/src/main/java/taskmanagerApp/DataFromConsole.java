package taskmanagerApp;

public class DataFromConsole {
	private String firstName;
	private String lastName;
	private String userName;
	private String taskTitle;
	private String taskDescription;

	public DataFromConsole(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

}
