package com.niit.goshop.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.goshop.dao.SuppliersDao;
import com.niit.goshop.models.Suppliers;


@Repository("suppliersDAO") 
@Transactional 
public class SuppliersDaoImpl implements SuppliersDao {
	@Autowired
private SessionFactory sessionFactory;
	public SuppliersDaoImpl(){
		System.out.println("SuppliersDaoImpl bean is created..");
	}
	public boolean addSuppliers(Suppliers suppliers) {
       Session session= sessionFactory.getCurrentSession();
       session.save(suppliers);//Generate insert query..
       return true;
	}
	public Suppliers getSuppliers(int id) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
		Suppliers suppliers=(Suppliers)session.get(Suppliers.class, id);
		//SQL query select * from product where id=?
		return suppliers;
		}
		catch (Exception e) {
			return null;
		}
	}
	@Override
	public boolean updateSupplier(Suppliers sup) {
		
		Session s=sessionFactory.getCurrentSession();
		try
		{
			s.update(sup);
			return true;
		}
		catch (Exception e)
		{
		return false;
		}
		
			
	}
	@Override
	public boolean deleteSupplier(int id) {
		Suppliers su=getSuppliers(id);
		Session s=sessionFactory.getCurrentSession();
		try 
		{
		s.delete(su);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	@Override
	public List<Suppliers> listSuppliers() {
		String s3="from Suppliers";
		Query y=sessionFactory.getCurrentSession().createQuery(s3);
		List<Suppliers> slist=y.list();
		return slist;
		
		
	}
	

}