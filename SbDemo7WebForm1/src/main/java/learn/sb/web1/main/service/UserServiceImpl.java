package learn.sb.web1.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sb.web1.main.entities.User;
import learn.sb.web1.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	//--------------------------------Register User--------------------------
	@Override
	public boolean registerUser(User user) {
		try {
			userRepository.save(user);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//--------------------------Get User's Email & password to check if its there in DB for login-------------
	@Override
	public User loginUser(String email, String pwd) {
		User validUser =userRepository.findByEmail(email);
		if(validUser!=null && validUser.getPassword().equals(pwd)) {
			System.out.println("Found Valid User");
			return validUser;
		}
		return null;
		
		
	}
	
	

}
