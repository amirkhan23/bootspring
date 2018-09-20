package springboot.main.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.main.dao.DeviceRepo;
import springboot.main.dao.DeviceUserMapRepo;
import springboot.main.dao.ProtocolRepo;
import springboot.main.dao.TagRepo;
import springboot.main.dao.UserRepo;
import springboot.main.entity.Device;
import springboot.main.entity.DeviceUserMap;
import springboot.main.entity.Protocol;
import springboot.main.entity.Tag;
import springboot.main.entity.User;
import springboot.main.services.DateFormatter;

@RestController
public class MainController {

	@Autowired
	ProtocolRepo protocolRepo;

	@Autowired
	TagRepo tagRepo;

	@Autowired
	DeviceRepo deviceRepo;

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	DeviceUserMapRepo deviceUserMapRepo;

	@Autowired
	DateFormatter df;

	/*
	 * 
	 * add tag in database
	 * 
	 */
	@RequestMapping(value = "/addTag", method = RequestMethod.POST)
	public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {

		return new ResponseEntity<>(tagRepo.save(tag), HttpStatus.CREATED);
	}

	/*
	 * 
	 * add device in database
	 * 
	 */
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public ResponseEntity<Device> addDevice(@RequestBody Device device) {

		return new ResponseEntity<>(deviceRepo.save(device), HttpStatus.CREATED);
	}

	/*
	 * 
	 * add protocol in database
	 * 
	 */
	// http://localhost:8080/addProtocol?device_id=1
	// hit url like this

	@RequestMapping(value = "/addProtocol", method = RequestMethod.POST)
	public ResponseEntity<Protocol> addProtocol(@RequestBody Protocol protocol,
			@RequestParam Map<String, String> device_id) {

		// check device in exists or not
		boolean chk = deviceRepo.exists(Integer.parseInt(device_id.get("device_id").trim()));

		System.out.println(chk);
		if (!chk) {
			return new ResponseEntity<>(protocol, HttpStatus.NOT_FOUND);
		}

		// if device in exists fetch details of device
		Device device = deviceRepo.findOne(Integer.parseInt(device_id.get("device_id").trim()));

		// set device in protocol
		protocol.setDevice(device);
		return new ResponseEntity<>(protocolRepo.save(protocol), HttpStatus.CREATED);
	}
	
	/*
	 * Add User in database
	 * 
	 */
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user, @RequestParam Map<String, String> tag_id) {

		boolean chk = tagRepo.exists(Integer.parseInt(tag_id.get("tag_id").trim()));
		System.out.println(chk);
		if (!chk) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		Tag t = tagRepo.findOne(Integer.parseInt(tag_id.get("tag_id").trim()));
		user.setTag_id(t);
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getListOfAllUser() {
		return (List<User>) userRepo.findAll();

	}

	/*
	 * 
	 * Add DeviceUserMap in database
	 * 
	 */
	@RequestMapping(value = "/addDeviceUserMap", method = RequestMethod.POST)
	public ResponseEntity<DeviceUserMap> addDeviceUserMap(@RequestBody DeviceUserMap deviceUserMap,
			@RequestParam Map<String, String> src) {

		// check device in exists or not
		boolean chk1 = deviceRepo.exists(Integer.parseInt(src.get("device_id").trim()));

		System.out.println(chk1);
		if (!chk1) {
			return new ResponseEntity<>(deviceUserMap, HttpStatus.NOT_FOUND);
		}

		boolean chk2 = userRepo.exists(Integer.parseInt(src.get("user_id").trim()));
		System.out.println(chk2);
		if (!chk2) {
			return new ResponseEntity<>(deviceUserMap, HttpStatus.NOT_FOUND);
		}

		
		// if device in exists fetch details of device
		Device device = deviceRepo.findOne(Integer.parseInt(src.get("device_id").trim()));
		User user = userRepo.findOne(Integer.parseInt(src.get("user_id").trim()));

		// set device in protocol
		deviceUserMap.setDevice(device);
		deviceUserMap.setUser(user);
		return new ResponseEntity<>(deviceUserMapRepo.save(deviceUserMap), HttpStatus.CREATED);
	}

}
