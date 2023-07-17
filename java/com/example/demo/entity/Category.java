package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	/**
	 * 
	 */
	public Category() {
		super();
	}

	/**
	 * @param name
	 */
	public Category(String name) {
		super();
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

}
