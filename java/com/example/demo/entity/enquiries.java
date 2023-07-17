package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiries")
public class enquiries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "customer_id")
	private Integer customerId;

	private String details;

	/**
	 * 
	 */
	public enquiries() {
		super();
	}

	/**
	 * @param customerId
	 * @param details
	 */
	public enquiries(Integer customerId, String details) {
		super();
		this.customerId = customerId;
		this.details = details;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

}
