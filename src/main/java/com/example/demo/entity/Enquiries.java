package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiries")
public class Enquiries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "enquiries_category_id")
	private Integer enquiriesCategoryId;

	private String details;

	/**
	 * 
	 */
	public Enquiries() {
		super();
	}

	/**
	 * @param customerId
	 * @param enquiriesCategoryId
	 * @param details
	 */
	public Enquiries(Integer customerId, Integer enquiriesCategoryId, String details) {
		super();
		this.customerId = customerId;
		this.enquiriesCategoryId = enquiriesCategoryId;
		this.details = details;
	}

	/**
	 * @return customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId セットする customerId
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return enquiriesCategoryId
	 */
	public Integer getEnquiriesCategoryId() {
		return enquiriesCategoryId;
	}

	/**
	 * @param enquiriesCategoryId セットする enquiriesCategoryId
	 */
	public void setEnquiriesCategoryId(Integer enquiriesCategoryId) {
		this.enquiriesCategoryId = enquiriesCategoryId;
	}

	/**
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details セットする details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
