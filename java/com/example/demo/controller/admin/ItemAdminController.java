package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemAdminController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/admin/items")
	public String index(
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		List<Item> itemList = null;
		if (categoryId == null) {
			itemList = itemRepository.findAll();
		} else {
			itemList = itemRepository.findByCategoryId(categoryId);
		}

		model.addAttribute("itemList", itemList);

		return "/admin/items";

	}

	@GetMapping("/admin/items/add")
	public String create(Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		return "/admin/addItem";
	}

	@PostMapping("/admin/items/add")
	public String store(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price,
			Model model) {

		Item item = new Item(categoryId, name, price);
		itemRepository.save(item);

		return "redirect:/admin/items";
	}

	@GetMapping("/admin/items/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);

		return "/admin/editItem";
	}

	@PostMapping("/admin/items/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price,
			Model model) {

		Item item = new Item(id, categoryId, name, price);
		itemRepository.save(item);

		return "redirect:/admin/items";
	}

	@PostMapping("/admin/items/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id,
			Model model) {

		itemRepository.deleteById(id);

		return "redirect:/admin/items";
	}
}
