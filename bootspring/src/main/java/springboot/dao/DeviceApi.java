package springboot.dao;

import java.util.List;

import springboot.model.Device;

public interface DeviceApi {
	
	public boolean save(Device device);
	public Device getDive(Device device);
	public List<Device> getAllDevices();
	

}
