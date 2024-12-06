package learn.sb.main;
//App to show how to use @Bean in Spring Boot



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import learn.sb.main.beans.Student;

@SpringBootApplication
//public class SbDemo1Application implements CommandLineRunner {
//In case if we want to have only main() in Main class
public class SbDemo1Application {

	public static void main(String[] args)  {
		SpringApplication.run(SbDemo1Application.class, args);
		System.out.println("App started");
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(stuBean().toString());
		
		
	}
	
	@Bean
	public Student stuBean() {
		return new Student("Supriya", 1, 100);
	}
	*/

}
