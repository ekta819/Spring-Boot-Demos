package learn.sb.web3.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sb.web3.main.entities.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//Its important to define the query method in REPO else
	//we'll not be able to call these methods directly from ServiceImpl 
	User  findByEmail(String email);

}
