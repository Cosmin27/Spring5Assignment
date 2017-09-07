package com.cgm.assignment4spring.controllers;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.assignment4spring.builders.ArtefactBuilder;
import com.cgm.assignment4spring.entities.User;

@Controller
public class LoginController {
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

			// System.out.println("USERNAME: " + user.getUsername() + " PASSWORD: " +
			// user.getPassword());
			for (User userAccount : ArtefactBuilder.userAccounts()) {
				if (userAccount.getUsername().equals(user.getUsername())
						&& userAccount.getPassword().equals(user.getPassword())) {
					request.getSession().setAttribute("logged", true);
					userAccount.setLogged(true);
					request.getSession().setAttribute("userAccount", userAccount);
					request.getSession().setAttribute("usernameString", userAccount.getUsername());

					return new ModelAndView("redirect:/", model.asMap());
				}
			}
			
			model.addAttribute("error", "Wrong username/password.");
			return new ModelAndView("login", model.asMap());
		}
		return new ModelAndView("redirect:/", model.asMap());

	}
}
