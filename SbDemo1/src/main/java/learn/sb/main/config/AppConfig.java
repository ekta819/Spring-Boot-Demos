package learn.sb.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learn.sb.main.beans.Student;

@Configuration
public class AppConfig {
	
	@Bean
	public CommandLineRunner clRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(stuBean1().toString());
				System.out.println(stuBean2().toString());
				
			}
		};
	}
	
	@Bean
	public Student stuBean1() {
		return new Student("Supriya", 1, 100);
	}
	
	@Bean
	public Student stuBean2() {
		return new Student("Yaha", 2, 80);
	}



}
