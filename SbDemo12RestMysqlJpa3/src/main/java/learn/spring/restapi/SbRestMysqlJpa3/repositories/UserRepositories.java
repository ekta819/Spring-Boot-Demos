package learn.spring.restapi.SbRestMysqlJpa3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.spring.restapi.SbRestMysqlJpa3.entities.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
	
}
