package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Component
@SessionScope
public class Cart {

	@Autowired
	ItemRepository itemRepository;

	private List<Item> itemList = new ArrayList<>();

	/**
	 * @return itemList
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * @return itemList
	 */
	public int getItemListSize() {
		return itemList.size();
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
	public void delete(int itemId, int quantity) {
		for (Item item : itemList) {
			if (item.getId() == itemId) {
				itemList.remove(item);
				break;
			}
		}
		Item item = itemRepository.findById(itemId).get();
		item.setCmt(item.getCmt() + quantity);
		itemRepository.save(item);
	}

	// カートの中身を全てクリア
	public void clear() {
		itemList.clear();
	}
}
