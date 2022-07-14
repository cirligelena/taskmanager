package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Here is one of the main entity we'll be using to introduce data in our table
 * "Users"
 * 
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId_generator")
	@SequenceGenerator(name = "userId_generator", allocationSize = 1)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "user_name")
	private String userName;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Task> tasklist = new HashSet<Task>();

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
	public User(int id, String firstName, String lastName, String userName) {
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

	public int getId() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public Set<Task> getTasklist() {
		return tasklist;
	}

	public void setTasklist(Set<Task> tasklist) {
		this.tasklist = tasklist;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + " Last Name: " + lastName + " UserName: " + userName;
	}

}
