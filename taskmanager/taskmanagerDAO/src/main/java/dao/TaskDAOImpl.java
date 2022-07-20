package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Task;
import entity.User;

public class TaskDAOImpl extends DAOAbstract<Task> implements TaskDAO<Task> {
	private static final Logger logger = LogManager.getLogger(TaskDAOImpl.class);

	public TaskDAOImpl() {
		this.clazz = Task.class;
	}

	public void assignTask(String userName, String taskTitle) {
		Session session = factory.openSession();
		Transaction tx = null;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cr1 = cb.createQuery(User.class);
		Root<User> root = cr1.from(User.class);
		cr1.select(root);
		CriteriaQuery<Task> cr2 = cb.createQuery(Task.class);
		Root<Task> root2 = cr2.from(Task.class);
		cr2.select(root2);
		try {
			tx = session.beginTransaction();
			Query<User> query = session.createQuery(cr1);
			List<User> list1 = query.getResultList();
			Query<Task> query2 = session.createQuery(cr2);
			List<Task> list2 = query2.getResultList();
			User user = list1.stream().filter(u -> u.getUserName().equals(userName)).findFirst().get();
			Task task = list2.stream().filter(t -> t.getTaskTitle().equals(taskTitle)).findFirst().get();
			user.getTasklist().add(task);
			task.setUser(user);
			session.persist(user);
			tx.commit();
			logger.info("Data has been written succesfully ");
		} catch (IllegalStateException e) {
			if (tx != null)
				tx.rollback();
			logger.error(e);
		} finally {
			session.close();
		}
	}
	/*
	 * public void assignTask(String userName, String taskTitle) { Session session =
	 * factory.openSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); Task task = new Task(); String q1 =
	 * "from Task where taskTitle = :taskTitleParam";
	 * 
	 * @SuppressWarnings("unchecked") Query<Task> query1 = session.createQuery(q1);
	 * query1.setParameter("taskTitleParam", taskTitle); task =
	 * query1.getSingleResult(); User user = new User(); String q2 =
	 * "from User where userName = :userNameParam";
	 * 
	 * @SuppressWarnings("unchecked") Query<User> query2 = session.createQuery(q2);
	 * query2.setParameter("userNameParam", userName); user =
	 * query2.getSingleResult(); user.getTasklist().add(task); task.setUser(user);
	 * session.persist(user); tx.commit();
	 * logger.info("Data has been written succesfully "); } catch
	 * (IllegalStateException e) { if (tx != null) tx.rollback(); logger.error(e); }
	 * finally {
	 * 
	 * session.close(); } }
	 */
}
