package learn.sb.datajpa1.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String rollno;
	
	@Column
	private String marks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	public Student() {}
	
	public Student(String name, String rollno, String marks) {
		//super();
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}

	public String display() {
		return "Student [id=" + id + "newLine(), name=" + name + ", rollno=" + rollno + ", marks=" + marks + "]";
	}
	
	
	
	
}
