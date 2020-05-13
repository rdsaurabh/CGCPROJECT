package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.common.Common;
import com.managers.CategoryManager;
import com.managers.ProductManager;
import com.models.Category;
import com.models.Product;
	
	@Controller
	public class ProductController {
	@RequestMapping("/add-product")
	String myProducts(ModelMap model) {
		CategoryManager cm = new CategoryManager();
		List<Category> catList = cm.getCategories(); 
		model.addAttribute("catList",catList);
	return "AddProducts";
	}

	@RequestMapping("/add-new-product")
	String productManager(@RequestParam String name,@RequestParam String description,
			@RequestParam Double mrp,@RequestParam Integer discount,@RequestParam Integer categoryId,
			@RequestPart MultipartFile imgOne,@RequestPart MultipartFile imgTwo ,@RequestParam String brand,
			HttpSession session) {
			String imgPathOne = Common.uploadImage(session, imgOne, "products");
			String imgPathTwo = Common.uploadImage(session, imgTwo, "products");
			Product product = new Product();
			product.setCategoryId(categoryId);
			product.setName(name);
			product.setDescription(description);
			product.setManufacturer(brand);
			product.setMrp(mrp);
			product.setDiscount(discount);
			product.setImgUrl1(imgPathOne);
			product.setImgUrl2(imgPathTwo);
			product.setStatus(1);
			ProductManager pm = new ProductManager();
			pm.addProduct(product);
		return "redirect:add-product";
	}
	
	@RequestMapping("/show-products/{categoryId}")
	String show(ModelMap model,@PathVariable Integer categoryId) {
		ProductManager pManager = new ProductManager();
		List<Product> productList = pManager.allProducts(categoryId);
		model.addAttribute("productList", productList);
		return "ShowProducts";
	}
	
	@RequestMapping("/product-details/{productId}")
	String showDetails(@PathVariable Integer productId,ModelMap modelMap) {
		ProductManager pManager = new ProductManager();
		Product product = pManager.getProductDetails(productId);
		modelMap.addAttribute("product",product);
		return "ProductDetails";
	}
	}
	
