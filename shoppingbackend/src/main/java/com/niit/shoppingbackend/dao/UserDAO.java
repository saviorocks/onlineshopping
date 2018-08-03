package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Address;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.User;

public interface UserDAO
{
	User get(int Id);
	
	//add users
	boolean addUser(User user);
	User getByEmail(String email);
	//add address	
	boolean addAddress(Address address);
	
	Address getAddress(int addressId);

	//alternative 
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
	//Address getBillingAddress(User user);
	//List<Address> listShippingAddresses(User user);
	
	
}
