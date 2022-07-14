
package dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

