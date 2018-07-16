package com.niit.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshopping.util.FileUploadUtility;
import com.niit.onlineshopping.validator.ProductValidator;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.model.Category;
import com.niit.shoppingbackend.model.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController 
{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		//set few fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation != null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if(operation.equals("category"))
			{
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	
	@RequestMapping(value = "/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		
		mv.addObject("title", "Manage Products");
		
		//fetching product from db
		Product nProduct = productDAO.get(id);
		
		//set product fetched
		mv.addObject("product", nProduct);

		return mv;
	}
	
	
	//handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSumission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request)
	{
		if(mProduct.getId() == 0)
		{
			new ProductValidator().validate(mProduct, results);
		}
		else
		{
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProducts", true);
			
			model.addAttribute("title", "Manage Products");
			
			model.addAttribute("message", "Validation Failed For Product Submission!");
			
			return "page";
		}
		
		//create a new product record
		if(mProduct.getId() == 0)
		{
			productDAO.add(mProduct);
		}
		else
		{
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		product.setActive(!product.isActive());
		
		productDAO.update(product);
		
		return (isActive)? 
				"You Have Successfully DeActivated The Product With Id "+product.getId() 
				: "You Have Successfully Activated The Product With Id "+product.getId();
	}
	
	//to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		//add new category
		categoryDAO.add(category);
		
		return "redirect:/manage/products/?operation=category";
	}
	
	//returning categories for all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	
}
