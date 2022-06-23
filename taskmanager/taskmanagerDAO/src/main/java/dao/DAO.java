package dao;


public interface DAO<T> {
	void insert(T t); 

	void select();

}
