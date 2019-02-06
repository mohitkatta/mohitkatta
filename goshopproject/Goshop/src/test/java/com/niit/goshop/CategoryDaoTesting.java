package com.niit.goshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.goshop.dao.CategoryDao;
import com.niit.goshop.models.Category;



public class CategoryDaoTesting 
{
	
	static CategoryDao categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDao)context.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategory_id(20);
		category.setCategory_name("WindowCurtain");
		category.setCategory_description("Various Variety of Window Curtains");
		
		assertTrue("Probem in Adding the Category",categoryDAO.addCategory(category));
	}
	
	//@Ignore
	@Test
	public void updateCategoryTest()
	{	
		Category category=categoryDAO.getCategory(20);
		category.setCategory_name("Wash");
		assertTrue("Problem in Updating ",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Category category=categoryDAO.getCategory(9);
		assertTrue("Problem in Updating ",categoryDAO.deleteCategory(9));
	}
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Category> listcats=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing",listcats.size()>0);
		
		for(Category cat:listcats)
		{
			System.out.print("Category ID:"+cat.getCategory_id());
			System.out.print("Category Name:"+cat.getCategory_name());
			
		}
	}
	

}




