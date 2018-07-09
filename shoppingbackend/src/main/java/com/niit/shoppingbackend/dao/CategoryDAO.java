package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Category;

public interface CategoryDAO 
{
	List<Category> list();
	
	Category get(int id);
}
