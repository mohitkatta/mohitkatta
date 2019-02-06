package com.niit.goshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.goshop.models.Suppliers;
@Repository("suppliersDAO") 
public interface SuppliersDao {
		boolean addSuppliers(Suppliers suppliers);
		Suppliers getSuppliers(int id);
		boolean updateSupplier(Suppliers s);
		boolean deleteSupplier(int id);
		List<Suppliers> listSuppliers();
		}

