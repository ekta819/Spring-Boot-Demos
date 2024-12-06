package learn.sb.hibernate3.main.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import learn.sb.hibernate3.main.config.HibernateConfig;
import learn.sb.hibernate3.main.entities.User;
@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User getUserDetails(Long id) {
		// TODO Auto-generated method stub

		User user = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			user = session.get(User.class, id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return user;
	}

}
