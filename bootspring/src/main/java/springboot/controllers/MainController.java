package springboot.controllers;

import java.util.Date;
import java.util.List;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.dao.DeviceImpl;
import springboot.dao.ProtocolImpl;
import springboot.dao.TagImpl;
import springboot.dao.UserImpl;
import springboot.model.Device;
import springboot.model.Protocol;
import springboot.model.Tag;
import springboot.model.User;

@RestController
@ComponentScan({ "springboot.dao" })
public class MainController {

	@Autowired
	DeviceImpl d;
	@Autowired
	ProtocolImpl p;
	@Autowired
	TagImpl t;
	@Autowired
	UserImpl u;

	@RequestMapping("/")
	public String getIndex() {

		return "index";
	}

	@RequestMapping(value = "/bootspring/device", method = RequestMethod.POST, consumes = "application/json")
	public String getJsondevice(@RequestBody Device device) {

		Protocol pro = new Protocol();
		pro.setTitle("p" + Math.random());
		pro.setCreated_On(new Date());
		pro.setEffectivity_date(new Date());
		device.setProtcol_id(pro);

		p.save(pro);

		boolean d1 = d.save(device);
		System.out.println(d1 + "  " + device);
		JSONObject json = new JSONObject();
		try {
			json.put("Device_id", device.getDevice_Id());
			json.put("operator_id", device.getOperator_id());
			json.put("status", device.getStatus());
			json.put("description", device.getDescription());
			json.put("pfrotocol_id", device.getProtcol_id());
		} catch (JSONException e) {

			e.printStackTrace();
		}
		return json.toString();

	}

	@RequestMapping(value = "/bootspring/user", method = RequestMethod.POST, consumes = "application/json")
	public String getUser(@RequestBody User user) {

		Tag tag = new Tag();
		tag.setCreated_On(new Date());
		tag.setIs_active("Y");
		tag.setDescription("Its a Tag ");
		t.save(tag);

		user.setTag_id(tag);

		user.setDevice(d.getAllDevices());
		boolean d1 = u.save(user);

		System.out.println(d1 + "  " + user);
		JSONObject json = new JSONObject();
		try {
			json.put("user_id", user.getUser_id());
			json.put("tag_id", user.getTag_id());
			json.put("email", user.getEmail());
			json.put("name", user.getUser_name());
			json.put("device_id", user.getDevice());
		} catch (JSONException e) {

			e.printStackTrace();
		}
		return json.toString();

	}

	@RequestMapping("/bootspring/getAllUser")
	public List<User> getAllUser() {
		List<User> getAllUser = u.getAllUsers();
		return getAllUser;
	}

}
