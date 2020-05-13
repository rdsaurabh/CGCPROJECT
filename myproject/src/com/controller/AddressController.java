package com.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.managers.AddressManager;
import com.models.Address;
import com.models.User;


@Controller
public class AddressController {
	@RequestMapping("/add-address")
	String address(@RequestParam String street,String landmark,@RequestParam String phone,@RequestParam String city,
			@RequestParam String state,@RequestParam String country,@RequestParam Integer pincode,HttpSession session
			) {
		User user = (User)session.getAttribute("logged_user");
		Address address = new Address();
		address.setStreet(street);
		address.setLandmark(landmark);
		address.setPhone(phone);
		address.setCity(city);
		address.setState(state);
		address.setCountry(country);
		address.setPincode(pincode);
		address.setUserId(user.getId());
		AddressManager am = new AddressManager();
		am.addAddress(address);
		
		return "redirect:make-payment";
	
	}
}
