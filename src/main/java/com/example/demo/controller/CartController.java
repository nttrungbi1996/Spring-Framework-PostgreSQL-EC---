package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.model.Cart;
import com.example.demo.repository.ItemRepository;

@Controller
public class CartController {

	@Autowired
	Cart cart;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/cart")
	public String index() {

		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("itemId") Integer itemId,
			@RequestParam(name = "quantity", defaultValue = "1") Integer quantity,
			Model model) {

		Item item = itemRepository.findById(itemId).get();

		if (item.getCmt() < quantity) {
			//model.addAttribute("msg", "在庫数が足りない");
			return "redirect:/items/" + itemId + "?msg=true";
		}
		item.setCmt(item.getCmt() - quantity);
		itemRepository.save(item);
		item.setQuantity(quantity);
		cart.add(item);

		return "redirect:/cart";
	}

	@GetMapping("/cart/delete")
	public String deleteCart(
			@RequestParam("itemId") Integer itemId,
			@RequestParam("quantity") Integer quantity) {

		cart.delete(itemId, quantity);

		return "redirect:/cart";
	}
}
