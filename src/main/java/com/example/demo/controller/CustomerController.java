package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.VOrderDetail;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.VOrderDetailRepository;

@Controller
public class CustomerController {

	@Autowired
	Account account;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	VOrderDetailRepository vOrderDetailRepository;

	@GetMapping("/customer")
	public String index(Model model) {

		Customer customer = customerRepository.findById(account.getCustomerid()).get();
		model.addAttribute("customer", customer);

		return "customer";
	}

	@GetMapping("/customer/history")
	public String history(Model model) {

		Customer customer = customerRepository.findById(account.getCustomerid()).get();
		model.addAttribute("customer", customer);

		List<Order> orderList = orderRepository.findByCustomerId(account.getCustomerid());
		if (orderList.size() == 0) {
			model.addAttribute("msg", "お客様はまだ何も購入していません");
		} else {
			model.addAttribute("orderList", orderList);
		}

		return "customerHistory";
	}

	@GetMapping("/customer/edit")
	public String edit(Model model) {

		Customer customer = customerRepository.findById(account.getCustomerid()).get();
		model.addAttribute("customer", customer);

		return "customerEdit";
	}

	@PostMapping("/customer/edit")
	public String update(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "tel", defaultValue = "") String tel,
			Model model) {

		Customer customer = customerRepository.findById(account.getCustomerid()).get();
		customer.setName(name);
		customer.setAddress(address);
		customer.setTel(tel);
		customerRepository.save(customer);

		model.addAttribute("customer", customer);

		return "customer";
	}

	@GetMapping("/customer/history/detail")
	public String historyDetail(
			@RequestParam("orderId") Integer orderId,
			Model model) {
		Customer customer = customerRepository.findById(account.getCustomerid()).get();
		model.addAttribute("customer", customer);

		List<Order> orderList = orderRepository.findByCustomerId(account.getCustomerid());
		model.addAttribute("orderList", orderList);

		Order order = orderRepository.findById(orderId).get();
		model.addAttribute("order", order);
		// 注文明細情報
		List<VOrderDetail> orderDetailList = vOrderDetailRepository.findByOrderId(orderId);
		if (orderDetailList != null && orderDetailList.size() > 0) {
			model.addAttribute("orderDetails", orderDetailList);
		}

		return "historyDetail";
	}
}
