package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "item_id")
	private Integer itemId;

	private Integer quantity;

	/**
	 * 
	 */
	public OrderDetail() {
		super();
	}

	/**
	 * @param orderId
	 * @param itemId
	 * @param quantity
	 */
	public OrderDetail(Integer orderId, Integer itemId, Integer quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param orderId セットする orderId
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @param itemId セットする itemId
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @return itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity セットする quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
