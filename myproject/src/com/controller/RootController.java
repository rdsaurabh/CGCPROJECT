package com.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.Common;
import com.managers.UserManager;
import com.models.User;

@Controller
public class RootController {

	@RequestMapping({ "/", "/home" })
	public String home() {
		return "SliderHome";
	}

	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}

	@ResponseBody
	@RequestMapping("/create-user")
	public String create(@RequestParam String name, @RequestParam String email, @RequestParam String pass) {
		UserManager manager = new UserManager();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(pass);
		user.setUserType("SUBSCRIBER");
		user.setStatus(0);
		if (manager.createUser(user)) {
			return "success";
		} else {
			return "failed";
		}
	}

	@RequestMapping("/verify-email/{token}")
	public String verifyEmail(@PathVariable String token, HttpServletRequest request) {
		UserManager manager = new UserManager();
		User u = manager.authenticUser(token);
		if (u != null) {
			return createSession(request, u, "");
		} else
			return "invalid token";
	}

	private String createSession(HttpServletRequest request, User u, String redirect) {
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("logged_user", u);
		if (u.getUserType().equals("ADMIN")) {
			return "redirect:adm-index";
		} else {
			return "redirect:/" + redirect;
		}
	}

	@RequestMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password,
			@RequestParam(value = "") String redirect, HttpServletRequest request) {
		UserManager manager = new UserManager();
		User user = manager.userLogin(email, password);
		if (user == null) {
			return "redirect:/";
		} else {
			return createSession(request, user, redirect);
		}
	}

	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/cart")
	String crt(){
		
		return "redirect:show-cart";
	}
	@RequestMapping("/show-cart")
	public String showCart() {
		return "CartItems";
	}

	@RequestMapping("/adm-index")
	public String admIndex() {
		return "admin-index";
	}

	@ResponseBody
	@RequestMapping("/signin-with-google")
	public String createGoogle(HttpServletRequest request) throws IOException, JSONException {
		String json = IOUtils.toString(request.getInputStream());
		JSONObject object = new JSONObject(json);
		UserManager manager = new UserManager();
		User user = new User();
		user.setName(object.getString("displayName"));
		System.out.println(object.getString("displayName"));
		user.setEmail(object.getString("email"));
		System.out.println(object.getString("email"));
		user.setPassword(Common.getRandomString());
		user.setUserType("SUBSCRIBER");
		user.setStatus(1);
		User loggedUser = manager.signinWithGoogle(user);
		
		if (loggedUser != null) {
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("logged_user", loggedUser);
			
			return "success";
		}
		
		return "failed";
	}

}
