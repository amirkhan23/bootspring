package springboot.main.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="User_id")
	private Integer user_id;
	
	@Column(name="User_name",nullable=false)
	private String user_name;
	
	@Email
	@NotNull
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="device_id")
	private Set<Device> device = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Tag tag_id;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
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

	public Set<Device> getDevice() {
		return device;
	}

	public void setDevice(Set<Device> device) {
		this.device = device;
	}

	public Tag getTag_id() {
		return tag_id;
	}

	public void setTag_id(Tag tag_id) {
		this.tag_id = tag_id;
	}

	

}
