package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.Cart;
import com.common.Common;
import com.managers.AddressManager;
import com.managers.OrderManager;
import com.models.Address;
import com.models.Order;
import com.models.OrderItems;
import com.models.Product;
import com.models.User;

@Controller		
public class OrderController {
	
	@RequestMapping("/checkout")
	String proceedCheckout(HttpSession session) {
		if(Common.isLoggedIn(session)==false)
		{
			return "redirect:cart-login";
		}
		return "redirect:make-payment";
	}

	@RequestMapping("/make-payment")
	String payment(HttpSession session,ModelMap model) {
		User loggedUser=Common.getLoggedUser(session);
		AddressManager manager=new AddressManager();
		
		List list=manager.getAddressByUserId(loggedUser.getId());
		model.addAttribute("addressList",list);
		return  "MakePayment";
	}
	
	@RequestMapping("/place-order")
	String plOrder(HttpSession hsession,Integer address,ModelMap modelMap) {
		Order order = new Order();
		User user = Common.getLoggedUser(hsession);
		Cart cart = Cart.getInstance();
		
		order.setId(Common.getRandomId());
		order.setTotal(cart.getTotal());
		order.setUserId(user.getId());
		order.setStatus(Common.PENDING);
		List orderItems=new ArrayList<>();
		for(Product p:cart) {
			OrderItems item=new OrderItems();
			item.setOrderId(order.getId());
			item.setMrp(p.getMrp());
			item.setProductId(p.getId());
			item.setQuantity(p.getQuantity());
			orderItems.add(item);
		}
		order.setOrderItems(orderItems);
		modelMap.addAttribute("order", order);
		Address ad = new AddressManager().getAddressByAddressId(address);
		order.setDeliveryAddress(ad.getCompleteAddress());
		OrderManager om = new OrderManager();
		om.placeOrder(order);
		return "CompletePayment";
	}
	
	
	
	@RequestMapping("/complete-payment")
	String compPay(@RequestParam Integer statusId,@RequestParam Integer orderId) {
		OrderManager om  =new OrderManager();
		Order order = om.getOrderById(orderId);
		Cart cart = Cart.getInstance();
		
		if(statusId == 1) {
			order.setStatus(Common.COMPLETED);
			om.updateOrder(order);
			cart.clear();
			}
		else {
			order.setStatus(Common.CANCELLED);
			om.updateOrder(order);
			cart.clear();
			}
		
		return "redirect:/";
	}
	

}
