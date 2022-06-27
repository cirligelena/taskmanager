package commands;


import objects.User;
import service.UserDAOService;

public class AddUserCommand implements Command {
	private String []args;
		
		AddUserCommand (String[] args){
			this.args = args;			 
		}
		public String [] getArgs() {
			return args;
		}
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(){
		String[] args = getArgs();
		User user = new User(args[1], args[2], args[3]);
		new UserDAOService().createDao().insert(user);
	}
}
