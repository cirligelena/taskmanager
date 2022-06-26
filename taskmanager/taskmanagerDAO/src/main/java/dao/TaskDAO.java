package dao;

import objects.Task;

public interface TaskDAO<T> extends DAO<T> {
	void insert(Task task);    
    
}