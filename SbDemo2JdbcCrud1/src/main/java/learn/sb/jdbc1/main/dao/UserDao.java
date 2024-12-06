package learn.sb.jdbc1.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import learn.sb.jdbc1.main.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//----------------------INSERT USER------------------------------------------
	public boolean insertUser(User user) {
		boolean status=false;
		try {
			String query="INSERT INTO users (name, email, gender, city) VALUES (?,?,?,?)";
			//update(sql,Object...)
			int count=jdbcTemplate.update(query, user.getName(),user.getEmail(), user.getGender(),user.getCity());
			if(	count>0) {
				status=true;
			}	
			else {
				status=false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			status=false;
			e.printStackTrace();
		} 
		return status;
	}
	
	//----------------------DELETE USER------------------------------------------
	
	public boolean deleteUserByEmail(String email) {
		boolean status=false;
		try {
			String query="DELETE FROM users where u_email=?";
			int count=jdbcTemplate.update(query, email);
			if(	count>0) {
				status=true;
			}	
			else {
				status=false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			status=false;
			e.printStackTrace();
		} 
		return status;
	}
	
	//----------------------SELECT ONE USER By EMAIL------------------------------------------
	/*public User getUserByEmail(String email) {
		String query="SELECT * FROM users WHERE u_email= ? ";
		//Use queryForObject(query, RowMapper) if we want to get only one object
		return jdbcTemplate.queryForObject(query, new UserRowMapper());
	}
	
	public static final class UserRowMapper implements RowMapper<User>{

		@Override
		public  User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User u=new User();
			
			//Use column name from db
			u.setName(rs.getString("u_name"));
			u.setEmail(rs.getString("u_email"));
			u.setGender(rs.getString("u_gender"));
			u.setCity(rs.getString("u_city"));
			return u;
		}
		
		
	}*/
	
	public List<User> getUserByEmail(String email) {
		String query="SELECT * FROM users WHERE u_email= ? ";
		//Use queryForObject(query, RowMapper) if we want to get only one object
		return jdbcTemplate.query(query, new UserRowMapper());
				
	}
	
	public static final class UserRowMapper implements RowMapper<User>{

		@Override
		public  User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User u=new User();
			
			//Use column name from db
			u.setName(rs.getString("u_name"));
			u.setEmail(rs.getString("u_email"));
			u.setGender(rs.getString("u_gender"));
			u.setCity(rs.getString("u_city"));
			return u;
		}
		
		
	}
}
