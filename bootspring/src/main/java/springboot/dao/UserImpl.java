package springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.model.User;

@Repository
@Service
@Transactional
public class UserImpl implements UserApi {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean save(User user) {

		entityManager.persist(user);
		return true;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> list = entityManager.createQuery("from User").getResultList();

		return list;

	}

}
