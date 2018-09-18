package springboot.main.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Device_id")
	private Integer device_Id;

	@Column(name = "Description")
	@NotNull
	private String description;

	enum Status {
		working, idle, complete
	}

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "OPERATOR_ID")
	@NotNull
	private int operator_id;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "protocol_Id", fetch = FetchType.EAGER)
	private Set<Protocol> protocol_Id = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "device", fetch = FetchType.EAGER)
	private Set<DeviceUserMap> device = new HashSet<DeviceUserMap>(0);

	public Device() {
	}

	public Device(String description, Status status, int operator_id, Set<Protocol> protocol_Id) {
		super();
		this.description = description;
		this.status = status;
		this.operator_id = operator_id;
		this.protocol_Id = protocol_Id;
	}

	public Integer getDevice_Id() {
		return device_Id;
	}

	public void setDevice_Id(Integer device_Id) {
		this.device_Id = device_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}

	public Set<Protocol> getProtocol_Id() {
		return protocol_Id;
	}

	public void setProtocol_Id(Set<Protocol> protocol_Id) {
		this.protocol_Id = protocol_Id;
	}

	public Set<DeviceUserMap> getDevice() {
		return device;
	}

	public void setDevice(Set<DeviceUserMap> device) {
		this.device = device;
	}

}
