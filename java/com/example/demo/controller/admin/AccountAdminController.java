package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountAdminController {

	@GetMapping("/admin/login")
	public String index() {

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

		return "redirect:/admin/items";
	}
}
