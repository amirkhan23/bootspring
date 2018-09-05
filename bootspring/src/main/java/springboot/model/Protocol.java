package springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Protocol")
@JsonIgnoreProperties(value = { "created_On", "effectivity_date" }, allowGetters = true)
public class Protocol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Protocol_id")
	private int protocol_Id;

	@Column(name = "Title")
	@Size(max = 200, message = "length is not greater than 200")
	@NotNull
	private String title;

	@Column(name = "Created_on")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date created_On;

	@Column(name = "Effectivity_date")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date effectivity_date;

	public Protocol() {
		super();
		
	}

	public int getProtocol_Id() {
		return protocol_Id;
	}

	public void setProtocol_Id(int protocol_Id) {
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

}
