package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@GetMapping("/order")
	public String index() {

		return "customerForm";
	}

	@PostMapping("/order/confirm")
	public String confirm(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			Model model) {

		Customer customer = new Customer(name, address, tel, email);
		model.addAttribute(customer);

		return "orderConfirm";
	}

	@GetMapping("/order/confirm")
	public String confirm(Model model) {

		Customer customer = customerRepository.findById(account.getCustomerid()).get();
		model.addAttribute(customer);

		return "orderConfirm";
	}

	@PostMapping("/order")
	public String doOrder(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			Model model) {

		//		Customer customer = new Customer(name, address, tel, email);
		//		customerRepository.save(customer);
		Customer customer = customerRepository.findById(account.getCustomerid()).get();

		Order order = new Order(
				customer.getId(),
				LocalDate.now(),
				cart.getTotalPrice());
		orderRepository.save(order);

		List<Item> itemList = cart.getItemList();
		List<OrderDetail> orderDetail = new ArrayList<>();
		for (Item item : itemList) {
			orderDetail.add(
					new OrderDetail(
							order.getId(),
							item.getId(),
							item.getQuantity()));
		}

		orderDetailRepository.saveAll(orderDetail);

		cart.clear();

		model.addAttribute("orderNumber", order.getId());

		return "ordered";
	}
}
