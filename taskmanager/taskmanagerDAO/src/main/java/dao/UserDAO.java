package dao;

import objects.User;

public interface UserDAO<T> extends DAO<T>  {
	void insert(User user); 
   
}
