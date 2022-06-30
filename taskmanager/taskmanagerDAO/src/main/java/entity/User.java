package entity;

/**
 * Here is one of the main entity we'll be using to introduce data in our table
 * "Users"
 * 
 */
public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String userName;

	/**
	 * Class constructor.
	 */
	public User() {
	}

	;

	/**
	 * Class constructor with @param firstName, lastName, userName
	 */
	public User(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	/**
	 * Class constructor adding additional @param id
	 */
	public User(String id, String firstName, String lastName, String userName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
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

	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID:" + id + "First Name: " + firstName + " Last Name: " + lastName + " UserName: " + userName;
	}

}
