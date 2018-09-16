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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToMany(mappedBy = "device", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Set<User> operator_id = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Protocol> protocol_Id;

}
