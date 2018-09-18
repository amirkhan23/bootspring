package springboot.main.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id")
	private Integer user_id;

	@Column(name = "User_name", nullable = false)
	private String user_name;

	@Email
	@NotNull
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TAG_ID")
	private Tag tag_id;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<DeviceUserMap> device = new HashSet<>(0);

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tag getTag_id() {
		return tag_id;
	}

	public void setTag_id(Tag tag_id) {
		this.tag_id = tag_id;
	}

	public Set<DeviceUserMap> getDevice() {
		return device;
	}

	public void setDevice(Set<DeviceUserMap> device) {
		this.device = device;
	}

}
