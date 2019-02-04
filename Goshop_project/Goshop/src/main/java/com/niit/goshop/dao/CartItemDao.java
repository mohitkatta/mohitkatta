package com.niit.goshop.dao;

import java.util.List;

import com.niit.goshop.models.CartItem;
import com.niit.goshop.models.User;

public interface CartItemDao {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem> getCartItems(String email);
	void deleteCartItem(int cartItemId);
	void updateCartItem(int cartItemId, int requestedQuantity);
	void updateCart(CartItem c);
	//CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}

