package com.niit.goshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.goshop.dao.SuppliersDao;
import com.niit.goshop.models.Suppliers;



public class SuppliersDaoTesting 
{
	
	static SuppliersDao suppliersDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		suppliersDAO=(SuppliersDao)context.getBean("suppliersDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Suppliers suppliers=new Suppliers();
		suppliers.setSuppliers_name("WindowCurtain");
		suppliers.setSuppliers_id(11);
		
		assertTrue("Probem in Adding the Category",suppliersDAO.addSuppliers(suppliers));
	}
	
	//@Ignore
			@Test
			public void updateSpplierTest()
			{	
				Suppliers suppliers=suppliersDAO.getSuppliers(11);
				try
				{
				suppliers.setSuppliers_name("Hanbin");	
				}
				catch(Exception e)
				{
					
				}
				assertTrue("Problem in Updating ",suppliersDAO.updateSupplier(suppliers));
			}
			@Ignore
			@Test
			public void deleteSupplierTest()
			{
				Suppliers suppliers=suppliersDAO.getSuppliers(5);
				assertTrue("Problem in deleting ",suppliersDAO.deleteSupplier(5));
			}
			@Ignore
			@Test
			public void listSuppliersTest()
			{
				List<Suppliers> listSuppliers=suppliersDAO.listSuppliers();
				
				assertTrue("Problem in Listing",listSuppliers.size()>0);
				
				for(Suppliers suppliers:listSuppliers)
				{
					System.out.print("Supplier ID:"+suppliers.getSuppliers_id());
					System.out.print("Supplier Name:"+suppliers.getSuppliers_name());
					
				}
			}
			
}




