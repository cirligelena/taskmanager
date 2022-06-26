package commands;


import objects.User;
import service.UserDAOService;

public class AddUserCommand implements Command {
	String []args;
	    String fn = args[1];
		String ln = args[2];
		String un = args[3];
		User user = new User(fn, ln, un);
		@SuppressWarnings("rawtypes")
		UserDAOService userDAOService = new UserDAOService();
		
		AddUserCommand (String []args){
			this.args = args;
		}
	

	@Override
	public void execute(){
		userDAOService.createDao().insert(user);
	}
}
