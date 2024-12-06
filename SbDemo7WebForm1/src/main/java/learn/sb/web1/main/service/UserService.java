package learn.sb.web1.main.service;

import org.springframework.stereotype.Service;
import learn.sb.web1.main.entities.User;


public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password);
	

}
