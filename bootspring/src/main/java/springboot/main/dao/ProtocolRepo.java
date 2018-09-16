package springboot.main.dao;

import org.springframework.data.repository.CrudRepository;

import springboot.main.entity.Protocol;

public interface ProtocolRepo extends CrudRepository<Protocol, Integer> {
	
	
}
