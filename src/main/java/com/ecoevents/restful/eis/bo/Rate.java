/**
 * 
 */
package com.ecoevents.restful.eis.bo;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ecoevents.restful.eis.bo.base.BaseEntity;

/**
 * @author developer
 *
 */
@Entity
@Table(name="rate_event")
public class Rate extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 483588409736135010L;
	@EmbeddedId
	private RateID rateId;
	private Integer rate;
	private String comment;
	private Date date;

	/**
	 * 
	 */
	public Rate() {
		super();
	}

	public Rate(RateID rateId, Integer rate, String comment, Date date) {
		super();
		this.rateId = rateId;
		this.rate = rate;
		this.comment = comment;
		this.date = date;
	}

	public RateID getRateId() {
		return rateId;
	}

	public void setId(RateID rateId) {
		this.rateId = rateId;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Rate [id=" + rateId + ", rate=" + rate
				+ ", comment=" + comment + ", date=" + date + "]";
	}

}
