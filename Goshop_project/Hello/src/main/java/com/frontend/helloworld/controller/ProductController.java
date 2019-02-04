package com.frontend.helloworld.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.goshop.dao.CategoryDao;
import com.niit.goshop.dao.ProductDao;
import com.niit.goshop.dao.SuppliersDao;
import com.niit.goshop.models.CartItem;
import com.niit.goshop.models.Category;
import com.niit.goshop.models.Product;
import com.niit.goshop.models.Suppliers;


@Controller
public class ProductController {
	@Autowired
	ProductDao productDAO;
	@Autowired
	CategoryDao categoryDAO;
	
	@Autowired
	SuppliersDao supplierDAO;
	
	@RequestMapping("/admin/Productpage")
	public ModelAndView pro()
	{
		 ModelAndView mv = new ModelAndView("Productpage","command",new Product());
		 mv.addObject("categories",categoryDAO.listCategories());
		 mv.addObject("productlist", productDAO.listProducts());
		 mv.addObject("suppliers",supplierDAO.listSuppliers());
		 return mv;
	}
	
	@RequestMapping("categorydisplay/{category_id}")
	public ModelAndView procatlist(@PathVariable("category_id") int cid)
	{
		ModelAndView mv=new ModelAndView("homepage");
		 mv.addObject("categorylist",categoryDAO.listCategories());
		List<Product> catplist=productDAO.getProductbycat(cid);
		mv.addObject("productlist",catplist);
		
		return mv;
	}
	
	
	 @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
	 public String addproduct(@ModelAttribute("SpringWeb")Product product, ModelMap model,HttpServletRequest request) {
		 Product p=productDAO.getProduct(product.getProduct_id());
		// System.out.println(p.getProduct_id());
				 int cid=product.getCategory().getCategory_id();
				 Category cat=categoryDAO.getCategory(cid);
				 product.setCategory(cat);
				 int sid=product.getSupplier().getSuppliers_id();
				 Suppliers sup=supplierDAO.getSuppliers(sid);
				 product.setSupplier(sup);
		 if(p==null)
		productDAO.addProduct(product);
		 else
			 productDAO.updateProduct(product);
		 
			System.out.println(request.getServletContext().getRealPath("/"));
			//Get the uploaded image and transfer the image to a file named productid.png 
			Path path=Paths.get(request.getServletContext().getRealPath("/")+ "/WEB-INF/resources/images/"+product.getProduct_id()+".jpg");
			
			MultipartFile img=product.getImage();//image uploaded by the user
			if(img!=null && !img.isEmpty()){
				File file=new File(path.toString());
				try {
					img.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
              return "redirect:/admin/Productpage";
   
	}
	 @RequestMapping("admin/updateproduct/{id}")
	 public ModelAndView updateproduct(@PathVariable("id") int id)
	 {
		 Product p=productDAO.getProduct(id);
		 ModelAndView mv=new ModelAndView("Productpage","command",p);
		 mv.addObject("categories",categoryDAO.listCategories());
		 mv.addObject("suppliers",supplierDAO.listSuppliers());
		
		 return mv;
	 }
	
	 @RequestMapping("admin/deleteproduct/{id}")
	 public String deleteProduct(@PathVariable("id") int id)
		{
			Product p=productDAO.getProduct(id);
			productDAO.deleteProduct(id);
//			ModelAndView mv = new ModelAndView("Productpage","command",new Product());
//			mv.addObject("productlist", productDAO.listProducts());
//			 return mv;
			 return "redirect:/admin/Productpage";
			
		}

}
