package com.frontend.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.goshop.dao.CategoryDao;
import com.niit.goshop.dao.ProductDao;
import com.niit.goshop.dao.UserDao;
import com.niit.goshop.models.User;




@Controller
public class UserController {
	@Autowired
	UserDao userDAO;
	
	@Autowired
	ProductDao productDAO;

	@Autowired
	CategoryDao categoryDAO;
	
	@RequestMapping("/signup")
	public ModelAndView sign()
	{
		ModelAndView mv = new ModelAndView("signup","command",new User());
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
		return mv;
		}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView adduser(@ModelAttribute("SpringWe")User user, ModelMap model) {
		
		userDAO.addUser(user);
		ModelAndView mv = new ModelAndView("signup","command",new User());
		mv.addObject("userlist", userDAO.listUsers());
		 return mv;
	}

}
