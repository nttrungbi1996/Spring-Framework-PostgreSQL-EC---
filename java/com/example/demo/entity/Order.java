package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "ordered_on")
	private LocalDate orderedOn;

	@Column(name = "total_price")
	private Integer totalPrice;

	/**
	 * 
	 */
	public Order() {
		super();
	}

	/**
	 * @param id
	 * @param customerId
	 * @param orderedOn
	 * @param totalPrice
	 */
	public Order(Integer customerId, LocalDate orderedOn, Integer totalPrice) {
		super();
		this.customerId = customerId;
		this.orderedOn = orderedOn;
		this.totalPrice = totalPrice;
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
	 * @param customerId セットする customerId
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return orderedOn
	 */
	public LocalDate getOrderedOn() {
		return orderedOn;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param orderedOn セットする orderedOn
	 */
	public void setOrderedOn(LocalDate orderedOn) {
		this.orderedOn = orderedOn;
	}

	/**
	 * @return totalPrice
	 */
	public Integer getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice セットする totalPrice
	 */
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
