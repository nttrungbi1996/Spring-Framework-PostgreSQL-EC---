package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiries_category")
public class EnquiriesCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	/**
	 * 
	 */
	public EnquiriesCategory() {
		super();
	}

	/**
	 * @param name
	 */
	public EnquiriesCategory(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

}
