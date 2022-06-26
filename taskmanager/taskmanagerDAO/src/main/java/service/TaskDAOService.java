package service;

import dao.DAOFactory;
import dao.TaskDAO;

public class TaskDAOService <TaskDAOImpl> implements Service<TaskDAOImpl>{
	
public TaskDAOService (){
}
	@Override
	public TaskDAO<?> createDao() {
		return (TaskDAO<?>) DAOFactory.getDAO("Task");
	}
}

