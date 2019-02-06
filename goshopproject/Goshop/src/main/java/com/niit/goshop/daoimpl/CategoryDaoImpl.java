package com.niit.goshop.daoimpl;


	import java.util.List;

import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.goshop.dao.CategoryDao;
import com.niit.goshop.models.Category;

	
	@Repository("categoryDAO") 
	@Transactional 
	public class CategoryDaoImpl implements CategoryDao {
		@Autowired
	private SessionFactory sessionFactory;
		public CategoryDaoImpl(){
			System.out.println("CategoryDaoImpl bean is created..");
		}
		public boolean addCategory(Category category) {
	       Session session= sessionFactory.getCurrentSession();
	       session.save(category);//Generate insert query..
	       return true;
		}
		public Category getCategory(int id) {
			Session session=sessionFactory.getCurrentSession();
			Category category=(Category)session.get(Category.class, id);
			//SQL query select * from product where id=?
			return category;
		}
		@Override
		public boolean updateCategory(Category cat) {
			
			Session s=sessionFactory.getCurrentSession();
			try {
			s.update(cat);
			return true;
			}
			catch(Exception e)
			{
			return false;
			}
		}
		@Override
		public boolean deleteCategory(int id) {
			Category c=getCategory(id);
			Session s=sessionFactory.getCurrentSession();
			try {
				s.delete(c);
				return true;
				}
				catch(Exception e)
				{
				return false;
				}
		}
		@Override
		public List<Category> listCategories() {
			String s="from Category";
			List<Category> clist=sessionFactory.getCurrentSession().createQuery(s).list();
			return clist;
		}
		

		

	}


