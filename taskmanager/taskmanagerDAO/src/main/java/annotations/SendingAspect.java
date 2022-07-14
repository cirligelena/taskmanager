package annotations;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SendingAspect {

	@After("@annotation(SendMail) && args(firstName, lastName, userName, taskTitle, taskDescription)")
	public void createMessage(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription) {
		String message = "New user { firstName:  " + firstName + " LastName: " + lastName + " UserName: " + userName
				+ "was created \n" + "and a task: { TaskTitle: " + taskTitle + "TaskDescription :" + taskDescription
				+ " }";
		new EmailSender().sendEmail(message);
	}

	@After("@annotation(SendMail) && args(firstName, lastName, userName)")
	public void createMessage(String firstName, String lastName, String userName) {
		String message = "New user { firstName:  " + firstName + " LastName: " + lastName + " UserName: " + userName
				+ "} was created";
		new EmailSender().sendEmail(message);
	}

	@After("@annotation(SendMail) && args(taskTitle, taskDescription)")
	public void createMessage(String taskTitle, String taskDescription) {
		String message = "A task: { TaskTitle: " + taskTitle + "TaskDescription :" + taskDescription + "} was added";
		new EmailSender().sendEmail(message);
	}
}
