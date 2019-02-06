package com.niit.goshop.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Suppliers {
	@Id
	private int suppliers_id;
	private String suppliers_name;
	@OneToMany
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getSuppliers_id() {
		return suppliers_id;
	}
	public void setSuppliers_id(int suppliers_id) {
		this.suppliers_id = suppliers_id;
	}
	public String getSuppliers_name() {
		return suppliers_name;
	}
	public void setSuppliers_name(String suppliers_name) {
		this.suppliers_name = suppliers_name;
	}
	
	

}
