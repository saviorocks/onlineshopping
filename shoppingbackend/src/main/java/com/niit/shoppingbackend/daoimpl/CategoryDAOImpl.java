package com.niit.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Repository;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// 1st entry
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television Description");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// 2st entry
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Mobile Description");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// 3rd entry
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Laptop Description");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) 
	{
		// enhanced for loop
		for(Category category : categories)
		{
			if(category.getId() == id) return category;
		}
		return null;
	}
	

}
