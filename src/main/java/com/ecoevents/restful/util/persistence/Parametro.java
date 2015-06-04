package com.ecoevents.restful.util.persistence;

import org.hibernate.type.Type;

public class Parametro {

	private String name;
	private String value;
	private Type type;

	public Parametro() {
		// TODO Auto-generated constructor stub
	}
	
	public Parametro(String name, String value, Type type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	
	public Parametro(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}


}
