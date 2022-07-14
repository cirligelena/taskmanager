package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Here is one of the main entity we'll be using to introduce data in our table
 * "Tasks"
 * 
 */
@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskId_generator")
	@SequenceGenerator(name = "taskId_generator", allocationSize = 1)
	@Column(name = "id")
	private int id;
	@Column(name = "task_title")
	private String taskTitle;
	@Column(name = "task_description")
	private String taskDescription;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	/**
	 * Class constructor.
	 */
	public Task() {
	}

	;

	/**
	 * Class constructor with @param taskTitle, taskDescription
	 */
	public Task(String taskTitle, String taskDescription) {
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

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

	@Override
	public String toString() {
		return "Task_title: " + taskTitle + " Task_description: " + taskDescription;
	}

}
