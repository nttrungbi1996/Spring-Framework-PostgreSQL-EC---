package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/items")
	public String index(Model model) {

		List<Category> categoryList = categoryRepository.findAllByOrderByIdAsc();
		model.addAttribute("categoryList", categoryList);

		return "categorys";
	}

	@GetMapping("/items/show")
	public String show(
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			@RequestParam(name = "maxPrice", defaultValue = "0") Integer maxPrice,
			Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		List<Item> itemList = null;
		//		if (categoryId != null && keyword.equals("") && maxPrice.equals("")) {
		//			itemList = itemRepository.findByCategoryId(categoryId);
		//		} else {
		if (!keyword.equals("") && maxPrice == 0 && categoryId == null) {
			itemList = itemRepository.findByNameLikeOrderByIdAsc("%" + keyword + "%");
		} else if (keyword.equals("") && maxPrice != 0 && categoryId == null) {
			itemList = itemRepository.findByPriceLessThanEqualOrderByIdAsc(maxPrice);
		} else if (!keyword.equals("") && maxPrice != 0 && categoryId == null) {
			itemList = itemRepository.findByPriceLessThanEqualAndNameLikeOrderByIdAsc(maxPrice, "%" + keyword + "%");
		} else if (!keyword.equals("") && maxPrice == 0 && categoryId != null) {
			itemList = itemRepository.findByNameLikeAndCategoryIdOrderByIdAsc("%" + keyword + "%", categoryId);
		} else if (keyword.equals("") && maxPrice != 0 && categoryId != null) {
			itemList = itemRepository.findByPriceLessThanEqualAndCategoryIdOrderByIdAsc(maxPrice, categoryId);
		} else if (keyword.equals("") && maxPrice == 0 && categoryId != null) {
			itemList = itemRepository.findByCategoryIdOrderByIdAsc(categoryId);
		} else if (!keyword.equals("") && maxPrice != 0 && categoryId != null) {
			itemList = itemRepository.findByPriceLessThanEqualAndNameLikeAndCategoryIdOrderByIdAsc(maxPrice,
					"%" + keyword + "%",
					categoryId);
		} else {
			itemList = itemRepository.findAllByOrderByIdAsc();
		}

		model.addAttribute("categoryId", categoryId);
		model.addAttribute("keyword", keyword);
		if (maxPrice != 0)
			model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("itemList", itemList);

		return "items";
	}

	@GetMapping("/items/item/{categoryId}")
	public String itemsCategory(
			@PathVariable("categoryId") Integer categoryId,
			Model model) {

		List<Item> itemList = itemRepository.findByCategoryIdOrderByIdAsc(categoryId);
		model.addAttribute("itemList", itemList);

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);

		return "items";
	}

	@GetMapping("/items/{id}")
	public String show(
			@RequestParam(name = "msg", defaultValue = "") String msg,
			@PathVariable("id") Integer id,
			Model model) {

		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		if (!msg.equals(""))
			model.addAttribute("msg", msg);

		return "itemDetail";
	}
}
