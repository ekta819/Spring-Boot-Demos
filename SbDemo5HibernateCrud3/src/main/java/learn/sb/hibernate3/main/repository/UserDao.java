package learn.sb.hibernate3.main.repository;

import learn.sb.hibernate3.main.entities.User;

public interface UserDao {
	
	public User getUserDetails(Long id);

}
