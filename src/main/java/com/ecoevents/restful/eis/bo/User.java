/**
 * 
 */
package com.ecoevents.restful.eis.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ecoevents.restful.eis.bo.base.BaseEntity;

/**
 * @author developer
 *
 */
@Entity
@Table(name="users")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -698238737572636535L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	@Column(unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private Integer age;

	/**
	 * 
	 */
	public User() {
		super();
	}


	public User(Integer id, String username, String password, String name, String email, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
