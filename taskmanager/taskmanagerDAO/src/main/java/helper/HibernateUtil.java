package helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.Task;
import entity.User;

public class HibernateUtil {
	private Helper helper = new Helper("hibernate.properties");
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Task.class);
		config.addProperties(helper.getProperties());

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		sessionFactory = config.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
