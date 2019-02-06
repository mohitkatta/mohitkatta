package com.frontend.helloworld.controller;



import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.goshop.dao.CartItemDao;
import com.niit.goshop.dao.OrderDetailsDao;
import com.niit.goshop.dao.ProductDao;
import com.niit.goshop.dao.UserDao;
import com.niit.goshop.models.CartItem;
import com.niit.goshop.models.OrderDetails;
import com.niit.goshop.models.Product;
import com.niit.goshop.models.User;

@Controller
public class CartItemController {
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDAO;
	@Autowired
	private OrderDetailsDao orderdetailsDao;
	@Autowired
	Product p;
	
	
		
	@RequestMapping(value="/cart/addtocart/{product_id}")
	public String addToCart(@PathVariable int product_id,
			@RequestParam int requestedQuantity,@AuthenticationPrincipal Principal principal){//get two values from jsp page
		//1st value - product id
		//2nd value - requested quantity
		//to get user, use Principal Object
		//user,product,totalPrice,requested quantity
		
		String email="";
		if(principal!=null)
		email=principal.getName();
		Product product=productDao.getProduct(product_id);
		User user=userDAO.getUser(email);
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(requestedQuantity);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getProduct_price()*requestedQuantity);
		cartItem.setUser(user);
		int flag=0;
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		if(cartItems.size()==0 && requestedQuantity<=product.getProduct_quantity())
		cartItemDao.addToCart(cartItem);
		else
		{
		for(CartItem ct:cartItems)
		{
			p=ct.getProduct();
			if(p.getProduct_id()==product_id)
			{
				flag=1;
				ct.setQuantity(ct.getQuantity()+requestedQuantity);
				ct.setTotalPrice(ct.getProduct().getProduct_price()*ct.getQuantity());
				System.out.println(ct.getQuantity());
				System.out.println(ct.getTotalPrice());
				if(ct.getQuantity()<=product.getProduct_quantity())
				{
			cartItemDao.updateCart(ct);
				}
			}
		}
			if(flag==0 && requestedQuantity<=product.getProduct_quantity())
			cartItemDao.addToCart(cartItem);
		
		}
		
		return "redirect:/cart/getcartitems";
	}
	
	
	
	@RequestMapping("/cart/getcartitems")
	public String getCartItems(@AuthenticationPrincipal Principal principal,Model model		){
		List<CartItem> cartItems=null;
		if(principal!=null)
		cartItems=cartItemDao.getCartItems(principal.getName());
		model.addAttribute("cartItems",cartItems);
		return "cart";
	}
	@RequestMapping("/cart/updatecartitem")
	public String updateCartItem(@RequestParam int cartItemId,@RequestParam int requestedQuantity){
		System.out.println(cartItemId + " " + requestedQuantity);
		cartItemDao.updateCartItem(cartItemId,requestedQuantity);
		return "redirect:/cart/getcartitems";
	}

	@RequestMapping(value="/cart/deletecartitem/{cartItemId}")
	public String deleteCartItem(@PathVariable int cartItemId){
	    cartItemDao.deleteCartItem(cartItemId);
		return "redirect:/cart/getcartitems";
	}
	
	
	@RequestMapping(value="/cart/createorder")
	public String createCustomerOrder(@AuthenticationPrincipal Principal principal,HttpSession session){
		//set updated shippingaddress in customer object 
		
		String email=principal.getName();
		User user=cartItemDao.getUser(email);
		
		
		OrderDetails customerOrder=new OrderDetails();
		customerOrder.setPurchaseDate(new Date());
		customerOrder.setUser(user);
		
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		double grandTotal=0.0;
		for(CartItem cartItem:cartItems){
			grandTotal=cartItem.getTotalPrice()+grandTotal;
		}
		customerOrder.setGrandTotal(grandTotal);
		orderdetailsDao.addOrder(customerOrder);
		for(CartItem cartItem:cartItems) {
			p=cartItem.getProduct();
			p.setProduct_quantity(p.getProduct_quantity()-cartItem.getQuantity());
			productDao.updateProduct(p);
			cartItemDao.deleteCartItem(cartItem.getCartItemId());
		}
		
		return "redirect:/orderdisplay";
	}
	

	}

