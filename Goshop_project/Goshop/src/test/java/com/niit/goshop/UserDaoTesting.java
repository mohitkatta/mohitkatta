package com.niit.goshop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.goshop.dao.UserDao;
import com.niit.goshop.models.User;



public class UserDaoTesting 
{
	
	static UserDao userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDao)context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		User user=new User();
		user.setUser_name("WindowCurtain");
		user.setUser_mailid("abc@gamil.com");
		user.setUser_phonenumber(8);
		user.setUser_address("xyz");
		
		
		assertTrue("Probem in Adding the Category",userDAO.addUser(user));
	}
	
	//@Ignore
			@Test
			public void updateUserTest()
			{	
				User user=userDAO.getUser("abc@gamil.com");
				//user.setUser_name("Jennie");
				user.setUser_phonenumber(1541451);
				assertTrue("Problem in Updating ",userDAO.updateUser(user));
			}
			@Ignore
			@Test
			public void deleteUserTest()
			{
				User user=userDAO.getUser("");
				assertTrue("Problem in deleting ",userDAO.deleteUser(""));
			}
			@Ignore
			@Test
			public void listUsersTest()
			{
				List<User> listUsers=userDAO.listUsers();
				
				assertTrue("Problem in Listing",listUsers.size()>0);
				
				for(User user:listUsers)
				{
					System.out.print("User emailID:"+user.getUser_mailid());
					System.out.print("User FirstName:"+user.getUser_name());
					System.out.println("User LastName:"+user.getUser_phonenumber());
					System.out.println("User LastName:"+user.getUser_password());
				}
			}
			
	}





