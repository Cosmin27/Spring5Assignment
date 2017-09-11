package com.cgm.assignment5spring.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.assignment5spring.domain.User;

@Controller
public class LogoutController {
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Locale locale, Model model, HttpServletRequest request) {
		if ((Boolean) request.getSession().getAttribute("logged")) {
			request.getSession().setAttribute("logged", false);
			request.getSession().removeAttribute("userID");
			request.getSession().removeAttribute("usernameString");
			// System.out.println("LOGGED OUT");
			return new ModelAndView("redirect:/", model.asMap());
		}
		return new ModelAndView("redirect:/", model.asMap());
	}
}
