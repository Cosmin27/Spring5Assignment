package com.cgm.assignment4spring.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView showAbout(Locale locale, Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("logged") == null) {
			request.getSession().setAttribute("logged", false);
		}
		return new ModelAndView("about", model.asMap());
	}
}
