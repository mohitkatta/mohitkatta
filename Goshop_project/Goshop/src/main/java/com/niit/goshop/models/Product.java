package com.niit.goshop.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;
	private int product_price;
	private String product_name;
	private int product_quantity;
	private String product_description;
	@OneToMany(mappedBy="product",cascade=CascadeType.REMOVE)
	private List<CartItem> cartitems;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Suppliers supplier;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Suppliers getSupplier() {
		return supplier;
	}
	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}

	@Transient //image will not get persisted in the database
	private  MultipartFile  image;
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public List<CartItem> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	

}
