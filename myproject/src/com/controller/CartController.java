package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Cart;
import com.managers.ProductManager;
import com.models.Product;

@Controller
public class CartController {
@RequestMapping("/add-to-cart")
String orderCart(@RequestParam Integer productId,@RequestParam Integer quantity) {
	ProductManager pm = new ProductManager();
	Product product = pm.getProductDetails(productId);
	product.setQuantity(quantity);
	Cart cart = Cart.getInstance();
	cart.add(product);
	return "redirect:cart";
	}

@RequestMapping("/mycart")
String cart() {
	return "CartItems";
}

@RequestMapping("/cart-login")
String cartLogin() {
	return "LogIn";
}
}
