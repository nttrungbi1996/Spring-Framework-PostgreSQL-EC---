package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class CustomerAdminController {

	@Autowired
	CustomerRepository customerRepositoriy;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/admin/customers")
	public String index(Model model) {

		List<Customer> customerList = customerRepositoriy.findAll();
		model.addAttribute("customerList", customerList);

		return "/admin/customers";
	}

	@GetMapping("/admin/customers/{id}/orders")
	public String show(
			@PathVariable("id") Integer id,
			Model model) {

		Customer customer = customerRepositoriy.findById(id).get();
		model.addAttribute("customer", customer);

		List<Order> orderList = orderRepository.findByCustomerId(id);
		model.addAttribute("orderList", orderList);

		List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderList.get(0).getId());
		model.addAttribute("orderDetailList", orderDetailList);

		return "/admin/customerOrders";
	}
}
