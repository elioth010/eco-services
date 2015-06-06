/**
 * 
 */
package com.ecoevents.restful.eis.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ecoevents.restful.eis.bo.base.BaseEntity;

/**
 * @author developer
 *
 */
@Entity
@Table(name="event")
public class Event extends BaseEntity implements Serializable {

	/**constraint
	 * 
	 */
	private static final long serialVersionUID = 4113578073617494074L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@JoinColumn(name="created_by", insertable=true)
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private User userCreated;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Date date;
	@Column
	private String place;

	/**
	 * 
	 */
	public Event() {
		super();
	}

	public Event(Integer id, User userCreated, String name, String description, Date date, String place) {
		super();
		this.id = id;
		this.userCreated = userCreated;
		this.name = name;
		this.description = description;
		this.date = date;
		this.place = place;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(User userCreated) {
		this.userCreated = userCreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", userCreated=" + userCreated + ", name="
				+ name + ", description=" + description + ", date=" + date
				+ ", place=" + place + "]";
	}
	
}
