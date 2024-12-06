package learn.sb.hibernate3.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import learn.sb.hibernate3.main.entities.User;
import learn.sb.hibernate3.main.repository.UserDao;

@SpringBootApplication
public class SbDemo4HibernateCrud2Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SbDemo4HibernateCrud2Application.class, args);
		//Configuration config=new Configuration();
	//	config.configure("learn/sb/hibernate3/main/resources/hibernate.cfg.xml");
		
		//SessionFactory sessionFactory=config.buildSessionFactory();
		//Session session=sessionFactory.openSession();
		
		/*
		 * Transaction not needed if we are Getting data form Database 
		 * Transaction transaction=session.beginTransaction();
		 */		
		
		UserDao ud=context.getBean(UserDao.class);
		User u=ud.getUserDetails(3L);
		
		if (u != null) {
			System.out.println(u.toString());
		} else {
			System.out.println("User Not Found");
		}
	}

}
