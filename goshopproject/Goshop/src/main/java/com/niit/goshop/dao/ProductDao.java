package com.niit.goshop.dao;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.niit.goshop.models.Product;
@Repository("productDAO") 
public interface ProductDao {
	boolean addProduct(Product product);
	Product getProduct(int id);
	boolean updateProduct(Product p);
	boolean deleteProduct(int id);
	List<Product> listProducts();
	List<Product> getProductbycat(int catid);
}
