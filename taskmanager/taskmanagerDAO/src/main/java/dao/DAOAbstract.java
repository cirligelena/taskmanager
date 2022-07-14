package dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import helper.HibernateUtil;

public abstract class DAOAbstract<T> implements DAO<T> {
	private static final Logger logger = LogManager.getLogger(DAOAbstract.class);
	protected SessionFactory factory = new HibernateUtil().getSessionFactory();
	protected List<T> list;
	protected Class<T> clazz;

	public void select() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<T> query = session.createQuery("from " + clazz.getName());
			list = query.list();
			tx.commit();
			for (T t : list) {
				System.out.println(t.toString());
			}
		} catch (IllegalStateException e) {
			if (tx != null)
				tx.rollback();
			logger.error(e);
		} finally {
			session.close();

		}
	}

	public void insert(T t) {
		Session session = factory.openSession();
		try {
			session.persist(t);
			logger.info("Data has been written succesfully ");
		} catch (HibernateException e) {
			logger.error(e);
		} finally {
			session.close();
		}
	}

}
