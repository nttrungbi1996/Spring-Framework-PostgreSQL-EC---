package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountAdminController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@GetMapping({ "/admin/login", "/admin", "/admin/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {

		session.invalidate();

		if (error.equals("notLoggedIn")) {
			model.addAttribute("msg", "ログインしてください");
		}

		return "/admin/login";
	}

	@PostMapping("/admin/login")
	public String login(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		if (name.equals("") || password.equals("")) {
			model.addAttribute("msg", "名前とパスワードを入力してください");
			return "/admin/login";
		} else if (!name.equals("admin") || !password.equals("himitu")) {
			model.addAttribute("msg", "ユーザ名とパスワードが一致しませんでした");
			return "/admin/login";
		}

		account.setName("ADMIN");

		return "redirect:/admin/items";
	}
}
