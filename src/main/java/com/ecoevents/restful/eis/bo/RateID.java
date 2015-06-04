package com.ecoevents.restful.eis.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RateID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5933442167619156991L;
	
	@Column(name="id_event")
	private Event event;
	@Column(name="id_user")
	private User user;
	
	public RateID() {
		super();
	}

	public RateID(Event event, User user) {
		super();
		this.event = event;
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}