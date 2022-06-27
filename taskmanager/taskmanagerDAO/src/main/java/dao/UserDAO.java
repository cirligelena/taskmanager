package dao;

import objects.User;
/**
* extends DAO and contains 1 additional method "insert" that will be implemented in the class UserDAOImpl 
* (contains SQL queries for introducing data in our table "Tasks")
*/
public interface UserDAO<T> extends DAO<T>  {
	void insert(User user); 
   
}
