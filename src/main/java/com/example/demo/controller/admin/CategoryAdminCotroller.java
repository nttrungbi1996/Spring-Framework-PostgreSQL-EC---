package com.example.demo.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class CategoryAdminCotroller {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/admin/categories")
	public String index(Model model) {

		List<Category> categoryList = categoryRepository.findAllByOrderByIdAsc();
		model.addAttribute("categoryList", categoryList);

		return "/admin/categories";

	}

	@GetMapping("/admin/categories/add")
	public String create() {

		return "/admin/addCategories";
	}

	@PostMapping("/admin/categories/add")
	public String store(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "avatar") MultipartFile file,
			Model model) {

		//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//		FileUploadUtil.saveFile(uploadDir, fileName, file);

		String fileName = file.getOriginalFilename();
		File saveFile = new File(
				"C:\\pleiades\\2022-12\\workspace\\personal_dev_3989_nguyen_thanhtrung\\src\\main\\resources\\static\\image\\"
						+ fileName);
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		Category category = new Category(name, fileName);
		categoryRepository.save(category);

		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {

		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category", category);

		return "/admin/editCategories";
	}

	@PostMapping("/admin/categories/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "avatar") MultipartFile file,
			@RequestParam("image") String image,
			Model model) {

		Category category = categoryRepository.findById(id).get();
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			File saveFile = new File(
					"C:\\pleiades\\2022-12\\workspace\\personal_dev_3989_nguyen_thanhtrung\\src\\main\\resources\\static\\image\\"
							+ fileName);
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			category = new Category(id, name, fileName);
		} else {
			category = new Category(id, name, image);
		}
		categoryRepository.save(category);

		return "redirect:/admin/categories";
	}

	@PostMapping("/admin/categories/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id,
			Model model) {

		categoryRepository.deleteById(id);

		return "redirect:/admin/categories";
	}
}
