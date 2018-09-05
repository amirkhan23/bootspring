package springboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Device_id")
	private int device_Id;

	@Column(name = "Description")
	@NotNull
	private String description;

	@Column(name = "Status")
	@NotNull
	private String status;

	@Column(name = "Operator_id")
	@NotNull
	private int operator_id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Protocol protcol_id;

	public int getDevice_Id() {
		return device_Id;
	}

	public void setDevice_Id(int device_Id) {
		this.device_Id = device_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}

	public Protocol getProtcol_id() {
		return protcol_id;
	}

	public void setProtcol_id(Protocol protcol_id) {
		this.protcol_id = protcol_id;
	}

	public Device() {
		super();
		
	}

	public Device(String description, String status, int operator_id, Protocol protcol_id) {
		super();
		this.description = description;
		this.status = status;
		this.operator_id = operator_id;
		this.protcol_id = protcol_id;
	}



	

}
