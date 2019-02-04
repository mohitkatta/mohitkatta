package com.niit.goshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.goshop.dao.ProductDao;
import com.niit.goshop.models.Category;
import com.niit.goshop.models.Product;



public class ProductDaoTesting 
{
	
	static ProductDao productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDao)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProduct_name("WindowCurtain");
		product.setProduct_description("Various Variety of Window Curtains");
		product.setProduct_id(10);
		product.setProduct_price(10);
		product.setProduct_quantity(10);
		assertTrue("Probem in Adding the Product",productDAO.addProduct(product));
	}
	
	//@Ignore
	@Test
	public void updateProductTest()
	{	
		Product product=productDAO.getProduct(10);
		try {
			product.setProduct_description("comfy");
		}
		catch(Exception e) {
			//TODO: handle excepton
		}
		
			assertTrue("Problem in Updating the Product",productDAO.updateProduct(product));
	}
		@Ignore
		@Test
		public void deleteProductTest()
		{
			Product product=productDAO.getProduct(003);
			assertTrue("Problem in deleting ",productDAO.deleteProduct(003));
		}
		
		
		
		@Ignore
		@Test
		public void listProductsTest()
		{
			List<Product> listProducts=productDAO.listProducts();
			
			assertTrue("Problem in Listing",listProducts.size()>0);
			
			for(Product product:listProducts)
			{
				System.out.print("Product ID:"+product.getProduct_id());
				System.out.print("Product Name:"+product.getProduct_name());
				System.out.println("Product Desc:"+product.getProduct_description());
				System.out.println("Product Price:"+product.getProduct_price());
				System.out.println("Product Quantity:"+product.getProduct_quantity());
			}
		}
		
	}

