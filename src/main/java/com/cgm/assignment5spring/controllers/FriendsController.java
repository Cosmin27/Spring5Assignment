package com.cgm.assignment5spring.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.assignment5spring.repository.UserDAO;

@Controller
public class FriendsController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public ModelAndView listUsers(Locale locale, Model model, HttpServletRequest request) {
		if ((Boolean) request.getSession().getAttribute("logged")) {
			return new ModelAndView("friends", model.asMap());
		}
		return new ModelAndView("redirect:/", model.asMap());
	}
}
