package learn.spring.restapi.SbRestMysqlJpa3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.spring.restapi.SbRestMysqlJpa3.entities.User;
import learn.spring.restapi.SbRestMysqlJpa3.repositories.UserRepositories;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepositories userRepository;

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
		
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
		
	}

	@Override
	public User updateUserById(int id, User user1) {
		User validUser = userRepository.findById(id).orElse(null);
		if(validUser!=null) {
			return userRepository.save(user1);
		}
		else {
			throw new RuntimeException("User not found with id : "+id);
		}
		
	}

	@Override
	public boolean deleteUserById(int id) {
		
		User validUser = userRepository.findById(id).orElse(null);
		if(validUser!=null) {
			userRepository.deleteById(id);
			return  true;
		}
		
		else {
			
			return false;
			
		}
	}
	
	

}
