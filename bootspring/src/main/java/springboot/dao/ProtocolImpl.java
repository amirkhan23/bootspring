package springboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.model.Protocol;

@Repository
@Service
@Transactional
public class ProtocolImpl implements ProtocolApi{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean save(Protocol protocol) {
		entityManager.persist(protocol);
		return true;
	}

	@Override
	public Protocol getDive(Protocol device) {
		
		return null;
	}

}
