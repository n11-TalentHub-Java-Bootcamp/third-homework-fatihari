package com.fatihari.homework3.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/* "user" is a reserved word in postgreSql and it is generally not a good idea to use reserved words for identifiers (tables or columns). 
 * Therefore, "user_account" is preferred as the table name.
 */
@Document(collection = "user_account") //table name(entity)
public class UserAccount 
{
    @Id
    @Column(name = "_id", nullable = false)
    private String _id;

	@Column(length = 50, name = "first_name")
	private String first_name;
	
	@Column(length = 50, name = "last_name")
	private String last_name;
	
    @Column(length = 20, name = "username")
    private String username;
	
	@Column(length = 50, name = "email")
	private String email;
	
	@Column(length = 15, name = "phone")
	private String phone;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserAccount [_id=" + _id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone=" + phone + ", username=" + username + "]";
	}


    
}
