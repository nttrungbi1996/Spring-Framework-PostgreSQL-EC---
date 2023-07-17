package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	private String name;
	private Integer customerid;

	/**
	 * 
	 */
	public Account() {
		super();
	}

	/**
	 * @param name
	 */
	public Account(String name, Integer customerId) {
		super();
		this.name = name;
		this.customerid = customerId;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return customerid
	 */
	public Integer getCustomerid() {
		return customerid;
	}

	/**
	 * @param integer セットする customerid
	 */
	public void setCustomerid(Integer integer) {
		this.customerid = integer;
	}

}
