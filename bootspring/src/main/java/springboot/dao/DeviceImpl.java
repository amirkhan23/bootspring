package springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.model.Device;

@Repository
@Service
@Transactional

public class DeviceImpl implements DeviceApi {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean save(Device device) {
		entityManager.persist(device);
		return true;
	}

	@Override
	public Device getDive(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Device> getAllDevices() {
		List<Device> list = entityManager.createQuery("from Device").getResultList();
		return list;
	}

}
