package springboot.main.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DeviceUserMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEVICEUSERMAP_ID")
	private Integer deviceUserMap_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEVICE_ID")
	private Device device;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;

	enum Is_active {
		Y, N
	}

	@Column(name = "Is_active")
	@Enumerated(EnumType.STRING)
	private Is_active is_active;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date created_on;

	public DeviceUserMap() {

	}

	public DeviceUserMap(Integer deviceUserMap_id, Device device, User user, Is_active is_active, Date created_on) {
		super();
		this.deviceUserMap_id = deviceUserMap_id;
		this.device = device;
		this.user = user;
		this.is_active = is_active;
		this.created_on = created_on;
	}

	public Integer getDeviceUserMap_id() {
		return deviceUserMap_id;
	}

	public void setDeviceUserMap_id(Integer deviceUserMap_id) {
		this.deviceUserMap_id = deviceUserMap_id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Is_active getIs_active() {
		return is_active;
	}

	public void setIs_active(Is_active is_active) {
		this.is_active = is_active;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

}
