package com.frontend.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.goshop.dao.SuppliersDao;
import com.niit.goshop.models.Suppliers;


@Controller
public class SupplierController {
	@Autowired
	SuppliersDao supplierDAO;
	
	
	
	
	
	
	

	@RequestMapping("/admin/Supplierpage")
	public ModelAndView sup()
	{
		ModelAndView mv = new ModelAndView("Supplierpage","command",new Suppliers());
		mv.addObject("supplierlist", supplierDAO.listSuppliers());
		return mv;	
	}
	@RequestMapping(value = "/admin/addsupplier", method = RequestMethod.POST)
    public String addsupplier(@ModelAttribute("SpringWeb")Suppliers supplier, ModelMap model) {
		Suppliers s=supplierDAO.getSuppliers(supplier.getSuppliers_id());
		if(s==null)
			supplierDAO.addSuppliers(supplier);
		else
			supplierDAO.updateSupplier(supplier);
//		ModelAndView mv = new ModelAndView("Supplierpage","command",new Supplier());
//		mv.addObject("supplierlist", supplierDAO.listSuppliers());
//		 return mv;
		return "redirect:/admin/Supplierpage";
	}
		 
		 @RequestMapping("admin/updatesupplier/{id}")
		 public ModelAndView updatesupplier(@PathVariable("id") int id)
		 {
			 Suppliers s=supplierDAO.getSuppliers(id);
			 ModelAndView mv=new ModelAndView("Supplierpage","command",s);
			 return mv;
		 }
		 @RequestMapping("admin/deletesupplier/{id}")
		 public String deleteSupplier(@PathVariable("id") int id)
			{
				Suppliers s=supplierDAO.getSuppliers(id);
				supplierDAO.deleteSupplier(id);
				return "redirect:/admin/Supplierpage";
			}
	
	

}
