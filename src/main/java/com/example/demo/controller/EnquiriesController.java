package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Enquiries;
import com.example.demo.entity.EnquiriesCategory;
import com.example.demo.model.Account;
import com.example.demo.repository.EnquiriesCategoryRepository;
import com.example.demo.repository.EnquiriesRepository;

@Controller
public class EnquiriesController {

	@Autowired
	Account account;

	@Autowired
	EnquiriesCategoryRepository enquiriesCategoryRepository;

	@Autowired
	EnquiriesRepository enquiriesRepository;

	@GetMapping("/enquiries")
	public String index(Model model) {

		List<EnquiriesCategory> enquiriesCategoryList = enquiriesCategoryRepository.findAll();
		model.addAttribute("enquiriesCategoryList", enquiriesCategoryList);

		return "enquiries";
	}

	@PostMapping("/enquiries")
	public String confirm(
			@RequestParam("enquiriesCategory") Integer enquiriesCategory,
			@RequestParam("content") String content,
			Model model) {

		Enquiries e = new Enquiries(account.getCustomerid(), enquiriesCategory, content);
		enquiriesRepository.save(e);

		return "thanks";
	}
}
