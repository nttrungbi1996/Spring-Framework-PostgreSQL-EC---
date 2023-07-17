package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_enquiries")
public class VEnquiries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "customer_id")
	private Integer customerId;

	private String name;

	private String details;

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
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

}
