package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.CartLine;
import com.niit.shoppingbackend.model.OrderDetail;

public interface CartLineDAO 
{

	//the common methods from previously coded one
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	//other bussiness method rrelated to the cart line
	public List<CartLine> listAvailable(int cartId);
	public CartLine getbyCartAndProduct(int cartId, int productId);
	
	//add cart
	boolean updateCart(Cart cart);
	
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);
}
