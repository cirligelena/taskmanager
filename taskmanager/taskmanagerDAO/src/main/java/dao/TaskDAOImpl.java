package dao;

import entity.Task;

public class TaskDAOImpl extends DAOAbstract<Task> implements TaskDAO<Task> {

	public TaskDAOImpl() {
		this.clazz = Task.class;
	}
}

