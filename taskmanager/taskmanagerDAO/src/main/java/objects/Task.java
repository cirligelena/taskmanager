package objects;
/**
* Here is one of the main entity we'll be using to introduce data in our table "Tasks"
* 
*/
public class Task {
	private int userID;
	private String userName;
	private String taskTitle;
	private String taskDescription;
	private String groupName;
	/** 
	* Class constructor.
	*/
	public Task() {
	}

	;
	/** 
	* Class constructor with @param UserID, taskTitle, taskDescription, groupName
	*/
	public Task(int userID, String taskTitle, String taskDescription, String groupName) {
		this.userID = userID;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.groupName = groupName;
	}
	/** 
	* Class constructor with @param UserName instead of UserID, taskTitle, taskDescription, groupName
	*/
	public Task(String userName, String taskTitle, String taskDescription, String groupName) {
		this.userName = userName;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.groupName = groupName;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "User: " + userID + " Task_title: " + taskTitle + " Task_description: " + taskDescription
				+ " Assigned to " + groupName;
	}
	
}
