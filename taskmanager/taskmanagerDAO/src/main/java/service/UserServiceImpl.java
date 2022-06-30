package service;

import dao.UserDAOImpl;
import entity.User;

public class UserServiceImpl implements UserService {
	private UserDAOImpl userDAOImpl = new UserDAOImpl();

	public UserServiceImpl() {
	}

	@Override
	public void addUser(String firstName, String lastName, String userName) {
		userDAOImpl.insert(new User(firstName, lastName, userName));

	}

	@Override
	public void showAllUsers() {
		userDAOImpl.select();

	}

}
