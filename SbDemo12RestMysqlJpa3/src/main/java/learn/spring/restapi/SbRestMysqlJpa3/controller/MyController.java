package learn.spring.restapi.SbRestMysqlJpa3.controller;

import org.springframework.web.bind.annotation.RestController;

import learn.spring.restapi.SbRestMysqlJpa3.entities.User;
import learn.spring.restapi.SbRestMysqlJpa3.repositories.UserRepositories;
import learn.spring.restapi.SbRestMysqlJpa3.services.UserService;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MyController {

	@Autowired
	UserService userServices;

	@PostMapping("/user")
	public User postMethodName(@RequestBody User user) {

		return userServices.createUser(user);

	}

	@GetMapping("/user")
	public List<User> getAllUserDetails() {

		return userServices.getAllUsers();

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetailsById(@PathVariable int id) {

		User u = userServices.getUserById(id).orElse(null);
		if (u != null) {
			return ResponseEntity.ok().body(u);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetailsById(@PathVariable int id, @RequestBody User newUser) {
		User updateUser = userServices.updateUserById(id, newUser);
		if (updateUser != null) {
			return ResponseEntity.ok().body(updateUser);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserDetailsById(@PathVariable int id) {
		boolean status=userServices.deleteUserById(id);
		if(status) {
			String succMsg = "User deleted successfully";
			return ResponseEntity.ok().body(succMsg);
		}
		else {
			String errorMsg = "User ID Not Found";
			return ResponseEntity.notFound().build();
		}

	}

}
