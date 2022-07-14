package service;

import annotations.SendMail;
import dao.UserDAOImpl;
import entity.Task;
import entity.User;

public class UserServiceImpl implements UserService {
	private UserDAOImpl userDAOImpl = new UserDAOImpl();

	public UserServiceImpl() {
	}

	@SendMail
	@Override
	public void addUser(String firstName, String lastName, String userName) {
		userDAOImpl.insert(new User(firstName, lastName, userName));

	}

	@Override
	public void showAllUsers() {
		userDAOImpl.select();

	}

	public void addTasktoUser(String userName, String taskTitle, String taskDescription) {
		userDAOImpl.insertTask(userName, new Task(taskTitle, taskDescription));
	}

	@Override
	@SendMail
	public void addUserAndTask(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription) {
		userDAOImpl.insertUserAndTask(new User(firstName, lastName, userName), new Task(taskTitle, taskDescription));

	}

}
