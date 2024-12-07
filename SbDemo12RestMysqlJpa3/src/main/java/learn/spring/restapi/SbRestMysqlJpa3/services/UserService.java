package learn.spring.restapi.SbRestMysqlJpa3.services;

import java.util.List;
import java.util.Optional;

import learn.spring.restapi.SbRestMysqlJpa3.entities.User;

public interface UserService {
	
	//To insert user
	public User createUser(User user);
	
	//To get all user details
	public List<User> getAllUsers();
	
	//to get user details by ID
	public Optional<User> getUserById(int id);
	
	//to update User details by ID
	public User updateUserById(int id, User user1);
	
	//to delete user by ID
	public boolean deleteUserById(int id);

}
