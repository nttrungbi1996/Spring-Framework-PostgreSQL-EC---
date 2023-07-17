package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping({ "/", "/login", "logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {

		session.invalidate();

		if (error.equals("notLoggedIn")) {
			model.addAttribute("errorMsg", "ログインしてください");
		}

		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		if (email.isEmpty() || password.isEmpty()) {
			model.addAttribute("errorMsg", "メールアドレスとパスワードを入力してください");
			return "login";
		}

		List<Customer> cList = customerRepository.findByEmailAndPassword(email, password);

		if (cList == null || cList.size() == 0) {
			model.addAttribute("msg", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}

		Customer customer = cList.get(0);

		account.setName(customer.getName());
		account.setCustomerid(customer.getId());

		return "redirect:/items";
	}

	@GetMapping("/account")
	public String create(Model model) {

		return "createAccount";
	}

	@GetMapping("/manual")
	public String manual(Model model) {

		return "manual";
	}

	@PostMapping("/account")
	public String store(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "tel", defaultValue = "") String tel,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {

		List<String> errorMsg = new ArrayList<>();

		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("tel", tel);
		model.addAttribute("email", email);

		if (name.equals("")) {
			errorMsg.add("名前は必須です");
		}

		if (address.equals("")) {
			errorMsg.add("住所は必須です");
		}

		if (tel.equals("")) {
			errorMsg.add("電話番号は必須です");
		}

		if (email.equals("")) {
			errorMsg.add("メールアドレスは必須です");
		} else {
			List<Customer> customerList = customerRepository.findByEmail(email);
			if (customerList.size() > 0) {
				errorMsg.add("登録済みのメールアドレスです");
			}
		}

		if (password.equals("")) {
			errorMsg.add("パスワードは必須です");
		}

		if (errorMsg.size() > 0) {
			model.addAttribute("errorMsg", errorMsg);
			return "createAccount";
		}
		Customer customer = new Customer(name, address, tel, email, password);
		customerRepository.save(customer);

		return "redirect:/login";
	}
}
