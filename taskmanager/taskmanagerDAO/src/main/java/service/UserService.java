package service;

/**
 * An auxiliary class used to get a necessary UserDAO method Was created in
 * order to restrict direct access from a command to DAO
 */
public interface UserService {
	public void addUser(String firstName, String lastName, String userName);

	public void showAllUsers();
}