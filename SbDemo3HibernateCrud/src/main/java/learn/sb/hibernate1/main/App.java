package learn.sb.hibernate1.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import learn.sb.hibernate1.entities.User;

//This is demo for Hibernate CRUD Operation using MAVEN project
// No spring/springBoot

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        User user=new User();
        //user.setId(1);
        user.setName("Sah");
        user.setEmail("hastag@gmail.com");
        user.setPassword("social");
        user.setGender("Male");
        user.setCity("Mumbai");
        
        Configuration cfg=new Configuration();
        cfg.configure("/learn/sb/hibernate1/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        
      //Transaction not needed if we are Getting data form Database
        Transaction transaction=session.beginTransaction();
        
        //------------------------------------Insert---------------------------------------
        /*
        try {
        	session.persist(user);
        	//To save data permanently in DB use commit()
        	transaction.commit();
        	System.out.println("User Added successfully");
        }
        catch (Exception e) {
			// TODO: handle exception
        	transaction.rollback();
        	e.printStackTrace();
        	System.out.println("Failed to add User successfully");
		}*/
        
        
        
        //-----------------------SELECT Operation---------------------------
        /*try {
        	User user1=session.get(User.class, 2L);
        	System.out.println(user1.toString());
        	//To save data permanently in DB use commit()
        	//transaction.commit();
        	System.out.println("Got Data for User successfully");
        }
        catch (Exception e) {
			// TODO: handle exception
        	//transaction.rollback();
        	e.printStackTrace();
        	System.out.println("Failed to get User data");
		}*/
        
        
      //-----------------------UPDATE Operation---------------------------
        
        
        
        try {
        	User userUpdate=session.get(User.class, 1L);
            userUpdate.setCity("Chennai");
        	session.merge(userUpdate);
        	transaction.commit();
        	System.out.println("Got Data for User successfully");
        }
        catch (Exception e) {
        	transaction.rollback();
        	e.printStackTrace();
        	System.out.println("Failed to get User data");
		}
    
    }
}
