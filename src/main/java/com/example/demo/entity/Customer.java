package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String address;

	private String tel;

	private String email;

	private String password;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param tel
	 * @param email
	 */
	public Customer(String name, String address, String tel, String email) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param tel
	 * @param email
	 */
	public Customer(String name, String address, String tel, String email, String password) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.password = password;
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

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param tel セットする tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
