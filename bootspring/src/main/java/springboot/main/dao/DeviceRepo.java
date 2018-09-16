package springboot.main.dao;

import org.springframework.data.repository.CrudRepository;

import springboot.main.entity.Device;

public interface DeviceRepo extends CrudRepository<Device, Integer> {

}
