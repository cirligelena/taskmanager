package service;


import dao.DAOFactory;
import dao.UserDAO;

public class UserDAOService<UserDAOImpl> implements Service<UserDAOImpl>{
	
public UserDAOService (){
}
	@Override
	public UserDAO<?> createDao() {
		return  (UserDAO<?>) DAOFactory.getDAO("User");
	}
}
