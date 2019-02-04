package com.frontend.helloworld.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.goshop.dao.CartItemDao;
import com.niit.goshop.dao.CategoryDao;
import com.niit.goshop.dao.OrderDetailsDao;
import com.niit.goshop.dao.ProductDao;
import com.niit.goshop.dao.UserDao;
import com.niit.goshop.models.OrderDetails;
import com.niit.goshop.models.Product;
import com.niit.goshop.models.User;
 
@Controller
public class HelloWorldController {
	@Autowired
	ProductDao productDAO;
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDAO;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	 OrderDetailsDao orderdetailsDao;
	
	String message = "Welcome to Spring MVC!";
	 
//	@RequestMapping("/")
//	public ModelAndView showMessage()
//	{
//		
//		
//		ModelAndView mv = new ModelAndView("homepage");
//		mv.addObject("categorylist",categoryDAO.listCategories());
//		mv.addObject("productlist",productDAO.listProducts());
//		
//		return mv;
//	}
	
//	@RequestMapping("/")
//	public String f1()
//	{
//		return "helloworld";
//	}
	
	

	
	@RequestMapping(value= {"/","/homepage"})
	public ModelAndView msg()
	{
		ModelAndView mv = new ModelAndView("homepage");
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
	return mv;
	}
	
	
//	@RequestMapping("/Navbar")
//	public ModelAndView nav()
//	{
//
//		ModelAndView mv = new ModelAndView("Navbar");
//		return mv;
//	}
	
	
	
	
	@RequestMapping("/signin")
	public ModelAndView in()
	{

		ModelAndView mv = new ModelAndView("signin");
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
		return mv;
	}
		

	
	
	
	@RequestMapping("/viewproduct/{product_id}")
	public ModelAndView view(@PathVariable("product_id") int id)
	{
		Product p=productDAO.getProduct(id);
		ModelAndView mv = new ModelAndView("viewproduct","product",p);
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
		return mv;
		
	}
	
	
	
	
	@RequestMapping("/carousel")
	public ModelAndView car()
	{
		ModelAndView mv = new ModelAndView("carousel");
		return mv;
		
	}
	@RequestMapping("/admin/adminpage")
	public ModelAndView url()
	{
		ModelAndView mv=new ModelAndView("url");
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
		return mv;
	}
	

	@RequestMapping("/orderdisplay")
	public String display(@AuthenticationPrincipal Principal principal,Model model){
		String email=principal.getName();
		User user=userDao.getUser(email);
		System.out.println(email);
	  List<OrderDetails> OrderDetails=orderdetailsDao.listOrders(email);
	  model.addAttribute("odlist",OrderDetails);
			return "orderdetails"; 
		
	}
	@RequestMapping("/Carddetails")
	public ModelAndView card()
	{
		ModelAndView mv = new ModelAndView("Carddetails");
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
		return mv;
	}
	
	@RequestMapping("/logoutsuccess")
	public ModelAndView signout()
	{
		ModelAndView mv = new ModelAndView("signin");
		mv.addObject("categorylist",categoryDAO.listCategories());
		mv.addObject("productlist",productDAO.listProducts());
		
		return mv;
		}
	
	
}