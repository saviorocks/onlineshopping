package com.niit.shoppingbackend.dao;

import com.niit.shoppingbackend.model.Address;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.User;

public interface UserDAO
{
	//add users
	boolean addUser(User user);
	User getByEmail(String email);
	//add address	
	boolean addAddress(Address address);
	//add cart
	boolean updateCart(Cart cart);
	
}
