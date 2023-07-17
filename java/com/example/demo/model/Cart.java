package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Item;

@Component
@SessionScope
public class Cart {

	private List<Item> itemList = new ArrayList<>();

	/**
	 * @return itemList
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList セットする itemList
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return TotalPrice
	 */
	public int getTotalPrice() {
		int result = itemList.stream().mapToInt(item -> item.getPrice() * item.getQuantity()).sum();

		return result;
	}

	// カート追加
	public void add(Item newItem) {
		Item existsItem = null;

		for (Item item : itemList) {
			if (item.getId() == newItem.getId()) {
				existsItem = item;
				break;
			}
		}

		if (existsItem == null) {
			itemList.add(newItem);
		} else {
			existsItem.setQuantity(existsItem.getQuantity() + newItem.getQuantity());
		}
	}

	// カートからの削除
	public void delete(int itemId) {
		for (Item item : itemList) {
			if (item.getId() == itemId) {
				itemList.remove(item);
				break;
			}
		}
	}

	// カートの中身を全てクリア
	public void clear() {
		itemList.clear();
	}
}
