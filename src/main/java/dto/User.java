package dto;

import javax.persistence.*;

@Table
@Entity(name = "user")

public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private int role_id;
	@Column(length = 60)
	private String password;
	private int address_id;
	private String status;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", role_id=" + role_id +
				", password='" + password + '\'' +
				", address_id=" + address_id +
				", status='" + status + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User(Integer id, String name, String email, int role_id, String password, int address_id, String status,String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role_id = role_id;
		this.password = password;
		this.address_id = address_id;
		this.status = status;
		this.role = role;
	}
}
