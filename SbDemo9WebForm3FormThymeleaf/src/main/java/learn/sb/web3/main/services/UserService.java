package learn.sb.web3.main.services;

import learn.sb.web3.main.entities.User;

public interface UserService {
	
	public boolean registerUser(User user);
	public User loginUser(String email, String password);

}
