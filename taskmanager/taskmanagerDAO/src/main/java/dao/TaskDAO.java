package dao;

/**
 * extends DAO and contains 1 additional method "insert" that will be
 * implemented in the class TaskDAOImpl that contains SQL queries for
 * introducing data in our table "Tasks"
 * 
 * @param <T>
 */
public interface TaskDAO<T> extends DAO<T> {

}