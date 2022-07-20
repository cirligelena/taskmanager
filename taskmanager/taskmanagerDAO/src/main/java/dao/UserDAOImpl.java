
package dao;

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

public class UserDAOImpl extends DAOAbstract<User> implements UserDAO<User> {
	private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

	public UserDAOImpl() {
		this.clazz = User.class;
	}

	public void selectUsersTasks(String userName) {
		Session session = factory.openSession();
		Transaction tx = null;
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cr = cb.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		cr.select(root);
		try {
			tx = session.beginTransaction();
			Query<User> query = session.createQuery(cr);
			list = query.getResultList();
			tx.commit();
			User user = list.stream().filter(u -> u.getUserName().equals(userName)).findFirst().get();
			System.out.println("User " + user.getUserName() + " has the following tasks: ");
			for (Task task : user.getTasklist()) {
				System.out.println(task);
			}
		} catch (IllegalStateException e) {
			if (tx != null)
				tx.rollback();
			logger.error(e);
		} finally {
			session.close();
		}
	}

	/*
	 * public void selectUsersTasks(String userName) { Session session =
	 * factory.openSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); User user = new User(); String q =
	 * "from User where userName = :userNameParam";
	 * 
	 * @SuppressWarnings("unchecked") Query<User> query2 = session.createQuery(q);
	 * query2.setParameter("userNameParam", userName); user =
	 * query2.getSingleResult(); System.out.println("User " + userName +
	 * " has the following tasks: "); for (Task task : user.getTasklist()) {
	 * System.out.println(task); } tx.commit(); } catch (IllegalStateException e) {
	 * if (tx != null) tx.rollback(); logger.error(e); } finally { session.close();
	 * } }
	 */

	@Override
	public void insertTask(String userName, Task task) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = new User();
			String q = "from User where userName = :userNameParam";
			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery(q);
			query.setParameter("userNameParam", userName);
			user = query.getSingleResult();
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

	@Override
	public void insertUserAndTask(User user, Task task) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			(user.getTasklist()).add(task);
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
}
