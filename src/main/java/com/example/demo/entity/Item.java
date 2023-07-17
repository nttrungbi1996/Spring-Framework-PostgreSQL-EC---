package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_id")
	private Integer categoryId;

	private String name;

	private String image;

	private Integer price;

	private Integer cmt;

	@Transient
	private Integer quantity;

	/**
	 * 
	 */
	public Item() {
		super();
	}

	/**
	 * @param id
	 * @param categoryId
	 * @param name
	 * @param price
	 * @param cmt
	 */
	public Item(Integer id, Integer categoryId, String name, Integer price, Integer cmt) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.cmt = cmt;
	}

	/**
	 * @param id
	 * @param categoryId
	 * @param name
	 * @param price
	 */
	public Item(Integer id, Integer categoryId, String image, String name, Integer price, Integer cmt) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.image = image;
		this.cmt = cmt;
	}

	/**
	 * @param categoryId
	 * @param name
	 * @param image
	 * @param price
	 * @param cmt
	 */
	public Item(Integer categoryId, String image, String name, Integer price, Integer cmt) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.image = image;
		this.price = price;
		this.cmt = cmt;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price
	 */
	public Integer getPrice() {
		return price;
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

	/**
	 * @return image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @return cmt
	 */
	public Integer getCmt() {
		return cmt;
	}

	/**
	 * @param cmt セットする cmt
	 */
	public void setCmt(Integer cmt) {
		this.cmt = cmt;
	}

}
