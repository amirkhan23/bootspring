package springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.model.Tag;

@Repository
@Service
@Transactional
public class TagImpl implements TagApi{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean save(Tag tag) {
		entityManager.persist(tag);
		return true;
	}

}
