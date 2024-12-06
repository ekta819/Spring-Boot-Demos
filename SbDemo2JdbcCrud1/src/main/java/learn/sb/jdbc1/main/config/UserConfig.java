package learn.sb.jdbc1.main.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learn.sb.jdbc1.main.dao.UserDao;
import learn.sb.jdbc1.main.entity.User;

@Configuration
public class UserConfig {
	@Autowired
	private UserDao userDao;
	
	@Bean
	public CommandLineRunner clRunner() {
		return new CommandLineRunner() {
			
			//------------------------INSERT USER--------------------------------------------
			/*
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				User user1=new User("Supriya","supriya.mandal@gmail.com","Female","Purulia");
				User user2=new User("Krish","krish.sky@gmail.com","Male","Punjab");
				User user3=new User("Rene","enre.eer@gmail.com","Male","Kerala");
				boolean status=userDao.insertUser(user3);
				
				if(status=true) {
					System.out.println("User added successfully");
				}
				
				else {
					System.out.println("Not added.. Try Again!!");
				}
			}
			*/
			
			//----------------------DELETE USER------------------------------------------
			/*
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				boolean status=userDao.deleteUserByEmail("supriya.mandal@gmail.com");
				if(status=true) {
					System.out.println("User deleted successfully");
				}
				
				else {
					System.out.println("Not deleted.. Try Again!!");
				}
			}*/
			
			//----------------------SELECT ONE USER By EMAIL------------------------------------------
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				List<User> u =userDao.getUserByEmail("krish.sky@gmail.com");
				for(User user:u) {
					System.out.println(user.getName());
					System.out.println(user.getEmail());
					System.out.println(user.getGender());
					System.out.println(user.getCity());
				}
			}
		};
	}
	
	
}
