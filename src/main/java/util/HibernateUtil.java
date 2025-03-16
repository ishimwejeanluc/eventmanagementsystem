package util;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import modal.Attendance;
import modal.Event;
import modal.Invitation;
import modal.User;





public class HibernateUtil {

	
	private static SessionFactory sessionFactory = null;
	
	
	public static SessionFactory getSession() {
		
		Configuration configuration = new Configuration();
		
		Properties settings = new Properties();
		
		settings.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/eventmngtsystem");
		settings.setProperty(Environment.USER, "postgres");
		settings.setProperty(Environment.PASS, "*****");
		settings.setProperty(Environment.SHOW_SQL, "true");
		settings.setProperty(Environment.HBM2DDL_AUTO, "update");
		//settings.setProperty(Environment.DRIVER, "org.postgresql.Driver");
		
		configuration.setProperties(settings);
		
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Event.class);
		configuration.addAnnotatedClass(Invitation.class);
		configuration.addAnnotatedClass(Attendance.class);
		
		
		
		sessionFactory =  configuration.buildSessionFactory();
		
		return sessionFactory;
	}
	
}
