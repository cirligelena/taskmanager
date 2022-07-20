package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<T> cr = cb.createQuery(clazz);
		Root<T> root = cr.from(clazz);
		cr.select(root);
		try {
			tx = session.beginTransaction();
			Query<T> query = session.createQuery(cr);
			list = query.getResultList();
			tx.commit();
			list.stream().forEach(e -> System.out.println(e));
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
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(t);
			logger.info("Data has been written succesfully ");
			tx.commit();
		} catch (IllegalStateException e) {
			if (tx != null)
				tx.rollback();
			logger.error(e);
		} finally {
			session.close();
		}
	}

}
