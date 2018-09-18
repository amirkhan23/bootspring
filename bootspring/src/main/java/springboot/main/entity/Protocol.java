package springboot.main.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Protocol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROTOCOL_ID")
	private Integer protocol_Id;

	@Column(name = "TITLE")
	@Size(max = 200, message = "length is not greater than 200")
	@NotNull
	private String title;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date created_On;

	@Column(name = "EFFECTIVITY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date effectivity_date;

	@JoinColumn(name = "DEVICE_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Device device;

	public Protocol() {
		super();

	}

	public Protocol(String title, Date created_On, Date effectivity_date, Device device) {
		super();
		this.title = title;
		this.created_On = created_On;
		this.effectivity_date = effectivity_date;
		this.device = device;
	}

	public Integer getProtocol_Id() {
		return protocol_Id;
	}

	public void setProtocol_Id(Integer protocol_Id) {
		this.protocol_Id = protocol_Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated_On() {
		return created_On;
	}

	public void setCreated_On(Date created_On) {
		this.created_On = created_On;
	}

	public Date getEffectivity_date() {
		return effectivity_date;
	}

	public void setEffectivity_date(Date effectivity_date) {
		this.effectivity_date = effectivity_date;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
