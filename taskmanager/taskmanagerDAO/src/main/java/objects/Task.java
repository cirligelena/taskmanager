package objects;

public class Task {
	private String insert_un;
	private String task_title;
	private String task_description;
	private String group_name;

	public Task() {
	}

	;

	public Task(String insert_un, String task_title, String task_description, String group_name) {
		this.insert_un = insert_un;
		this.task_title = task_title;
		this.task_description = task_description;
		this.group_name = group_name;
	}

	public String getInsert_un() {
		return insert_un;
	}

	public void setInsert_un(String insert_un) {
		this.insert_un = insert_un;
	}

	public String getTask_title() {
		return task_title;
	}

	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	@Override
	public String toString() {
		return "User_name: " + insert_un + " Task_title: " + task_title + " Task_description: " + task_description
				+ " Assigned to " + group_name;
	}
}
