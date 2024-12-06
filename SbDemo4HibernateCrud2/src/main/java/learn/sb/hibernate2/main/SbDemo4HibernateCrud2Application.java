package learn.sb.hibernate2.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import learn.sb.hibernate2.main.entities.User;

@SpringBootApplication
public class SbDemo4HibernateCrud2Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDemo4HibernateCrud2Application.class, args);
		Configuration config=new Configuration();
		config.configure("learn/sb/hibernate2/main/config/hibernate.cfg.xml");
		
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		//Transaction not needed if we are Getting data form Database
	//	Transaction transaction=session.beginTransaction();
		
		try {
			User user=session.get(User.class, 5L);
			if(user!=null) {
				System.out.println(user.toString());
			}
			else {
				System.out.println("User Not Found");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
