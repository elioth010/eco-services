package com.ecoevents.restful.eis.bo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RateID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5933442167619156991L;
	
	@JoinColumn(name="id_event", insertable=true)
	@ManyToOne(targetEntity=Event.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Event event;
	@JoinColumn(name="id_user", insertable=true)
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
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