package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.common.Common;
import com.managers.CategoryManager;
import com.models.Category;

@Controller
public class CategoryController {

	@RequestMapping("/add-cat")
	public String category() {
		return "CategoryList";
	}

	@RequestMapping("/add-new-cat")
	public String add(@RequestParam String name, @RequestParam String description, @RequestPart MultipartFile image,
			HttpSession session) {
		CategoryManager manager = new CategoryManager();
		Category category = new Category();
		category.setName(name);
		category.setDescription(description);
		String imgPath = Common.uploadImage(session, image, "category");
		category.setImgUrl(imgPath);
		manager.addCategory(category);
		return "CategoryList";
	}

	@RequestMapping("/show-category")
	String show() {
		CategoryManager categoryManager = new CategoryManager();
		return "CatPage";
	}

}
