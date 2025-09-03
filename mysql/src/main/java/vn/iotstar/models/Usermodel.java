package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class Usermodel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idusers;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String images;
	private String phone;
	private int roleid;
	private Date createDate;
	
	// chuột phải - source - generate constructor using Fields - deselect all
	public Usermodel() {
		super();
	}
	
	// chuột phải - source - generate constructor using Fields 

	public Usermodel(int idusers, String username, String email, String password, String fullname, String images,
			String phone, int roleid, Date createDate) {
		super();
		this.idusers = idusers;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
	}
	
	// chuột phải - source - getter setter - select all

	public int getIdusers() {
		return idusers;
	}

	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	
	// chuột phải - source - generate to string
	@Override
	public String toString() {
		return "Usermodel [idusers=" + idusers + ", username=" + username + ", email=" + email + ", password="
				+ password + ", fullname=" + fullname + ", images=" + images + ", phone=" + phone + ", roleid=" + roleid
				+ ", createDate=" + createDate + "]";
	}
	
	 
	
	
	
	
	
}
