package springboot.main.dao;

import org.springframework.data.repository.CrudRepository;

import springboot.main.entity.DeviceUserMap;

public interface DeviceUserMapRepo extends CrudRepository<DeviceUserMap, Integer> {

}
