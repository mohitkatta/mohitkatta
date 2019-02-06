package com.niit.goshop.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.stereotype.Repository;

import com.niit.goshop.models.OrderDetails;
import com.niit.goshop.models.Product;

@Repository("orderdetailsDao")
public interface OrderDetailsDao {
	boolean addOrder(OrderDetails order);
	OrderDetails getOrder(int id);
	List<OrderDetails> listOrders(String email);
//	public List<OrderDetails> listProductswiseOrderdetails(int product_id);
	

}
