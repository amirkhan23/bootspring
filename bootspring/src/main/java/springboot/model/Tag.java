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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Tag")
@JsonIgnoreProperties(allowGetters = true)
public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private int tag_id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "Is_active", nullable = false)
	private String is_active;

	@Column(name = "created_On", nullable = false)
	private Date created_On;

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Date getCreated_On() {
		return created_On;
	}

	public void setCreated_On(Date created_On) {
		this.created_On = created_On;
	}

}
