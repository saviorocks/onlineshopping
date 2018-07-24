	package com.niit.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.onlineshopping.model.RegisterModel;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.model.Address;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.User;

@Component
public class RegisterHandler 
{

	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() 
	{ 
		return new RegisterModel();
	} 
	
	public void addUser(RegisterModel registerModel, User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model)
	{
		String transitionValue = "success";
		
		//fetch user
		User user = model.getUser();
		
		if(user.getRole().equals("USER"))
		{
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save the user
		userDAO.addUser(user);
		
		//get the address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
}
