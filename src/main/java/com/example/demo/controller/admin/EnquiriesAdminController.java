package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.VEnquiries;
import com.example.demo.repository.VEnquiriesRepository;

@Controller
public class EnquiriesAdminController {

	@Autowired
	VEnquiriesRepository vEnquiriesRepository;

	@GetMapping("/admin/enquiries")
	public String index(Model model) {

		List<VEnquiries> vEnquiriesList = vEnquiriesRepository.findAll();
		model.addAttribute("lists", vEnquiriesList);

		return "/admin/enquiries";
	}
}
