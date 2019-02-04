package com.niit.goshop.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.goshop.dao.UserDao;
import com.niit.goshop.models.Authorities;
import com.niit.goshop.models.User;


@Repository("userDAO") 
@Transactional 
public class UserDaoImpl implements UserDao {
	@Autowired
private SessionFactory sessionFactory;
	public UserDaoImpl(){
		System.out.println("ProductDaoImpl bean is created..");
	}
	public boolean addUser(User user) {
       Session session= sessionFactory.getCurrentSession();
       Authorities authorities=user.getAuthorities();
       authorities.setUser(user);
       session.save(user);//Generate insert query..
       return true;
	}

	public User getUser(String s) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
		User user=(User)session.get(User.class, s);
		//SQL query select * from user where id=?
		return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@Override
	public boolean updateUser(User user) {
		
		Session s=sessionFactory.getCurrentSession();
		try {
		s.update(user);
		return true;
		}
		catch(Exception e1)
		{
			return false;
		}
		
		
	}
	@Override
	public boolean deleteUser(String em) {
		User u=getUser(em);
		Session s=sessionFactory.getCurrentSession();
		try
		{
			s.delete(u);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	@Override
	public List<User> listUsers() {
		String s4="from User";
		Query e=sessionFactory.getCurrentSession().createQuery(s4);
		List<User> ulist=e.list();
		return ulist;
			
	}
	

}