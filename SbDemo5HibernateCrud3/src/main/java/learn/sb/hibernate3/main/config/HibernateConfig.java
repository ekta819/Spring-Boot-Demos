package learn.sb.hibernate3.main.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	public static SessionFactory getSessionFactory() {
		
		//shifted this part here from Main() so that we don't have to create buildSessionFactory() object
		//again and again as its not recommended because its heavy weight 
		Configuration config=new Configuration();
		config.configure("learn/sb/hibernate3/main/resources/hibernate.cfg.xml");
		return config.buildSessionFactory();
	}
	
	

}
