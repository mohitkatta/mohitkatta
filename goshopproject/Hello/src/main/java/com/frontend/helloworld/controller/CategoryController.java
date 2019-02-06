package com.frontend.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.goshop.dao.CategoryDao;
import com.niit.goshop.models.Category;
import com.niit.goshop.models.Product;



@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDAO;
	
	@RequestMapping("/admin/Categorypage")
	public ModelAndView cat()
	{
		ModelAndView mv = new ModelAndView("Categorypage","command",new Category());
		mv.addObject("categorylist", categoryDAO.listCategories());
		return mv;
		}
	@RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public String addcategroy(@ModelAttribute("SpringWeb")Category category, ModelMap model) {
		Category c=categoryDAO.getCategory(category.getCategory_id());
		if(c==null)
			categoryDAO.addCategory(category);
		else 
			categoryDAO.updateCategory(category);
//		ModelAndView mv = new ModelAndView("Categorypage","command",new Category());
//		mv.addObject("categorylist", categoryDAO.listCategories());
//		 return mv;
		return "redirect:/admin/Categorypage";
	}
	@RequestMapping("admin/updatecategory/{id}")
	 public ModelAndView updatecategory(@PathVariable("id") int id)
	 {
		 Category c=categoryDAO.getCategory(id);
		 ModelAndView mv=new ModelAndView("Categorypage","command",c);
		 return mv;
	 }
	
	 
	 @RequestMapping("admin/deletecategory/{id}")
	 public String deleteCategory(@PathVariable("id") int id)
		{
			Category c=categoryDAO.getCategory(id);
			categoryDAO.deleteCategory(id);
			return "redirect:/Categorypage";
		}
	
}
