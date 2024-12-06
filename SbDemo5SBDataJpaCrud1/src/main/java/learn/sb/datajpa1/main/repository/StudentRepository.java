package learn.sb.datajpa1.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sb.datajpa1.main.entities.Student;

//To use JpaRepository's in-bult methods we need this interface
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	 

}
