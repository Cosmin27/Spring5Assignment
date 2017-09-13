package com.cgm.assignment5spring.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.assignment5spring.domain.User;
import com.cgm.assignment5spring.repository.UserDAO;
import com.cgm.assignment5spring.services.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Locale locale, Model model, HttpServletRequest request) {
		if (!(Boolean) request.getSession().getAttribute("logged")) {
			model.addAttribute("login", new User());
			return new ModelAndView("login", model.asMap());
		}
		return new ModelAndView("redirect:/", model.asMap());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doLogin(@ModelAttribute("login") User user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (!(Boolean) request.getSession().getAttribute("logged")) {
			// validation result
			if (result.hasErrors()) {
				return new ModelAndView("login", model.asMap());
			}
			
			if(loginService.checkLogin(user)) {
				request.getSession().setAttribute("logged", true);
				//request.getSession().setAttribute("userAccount", user);
				request.getSession().setAttribute("usernameString", user.getUser_name());
				request.getSession().setAttribute("userID", loginService.getUserIDForUsername(user.getUser_name()));

				return new ModelAndView("redirect:/", model.asMap());
			}
			
			model.addAttribute("error", "Wrong username/password.");
			return new ModelAndView("login", model.asMap());
		}
		return new ModelAndView("redirect:/", model.asMap());

	}
}
