package learn.sb.web3.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sb.web3.main.entities.User;
import learn.sb.web3.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

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

	@Override
	public User loginUser(String email, String password) {
		User validUser=userRepository.findByEmail(email);
		if(validUser!=null && validUser.getPassword().equals(password)) {
			return validUser;
		}
		return null;
	}

}
