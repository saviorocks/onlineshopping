package com.niit.onlineshopping.service;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.onlineshopping.model.UserModel;
import com.niit.shoppingbackend.dao.CartLineDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.CartLine;
import com.niit.shoppingbackend.model.Product;

@Service("cartService")
public class CartService 
{
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	//returns cart of the user who has logged in
	private Cart getCart()
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns the entire cart line
	public List<CartLine> getCartLines()
	{
		return cartLineDAO.list(this.getCart().getId());
	}

	public String updateCartLine(int cartLineId, int count) 
	{
		//fetch the cartline
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null)
		{
			return "result=error";
		}
		else
		{
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() < count)
			{
				return "result=unavailable";
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			
			cartLineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
		}
		
	}
	public String addCartLine(int productId) 
	
	{
		String response =null;
		Cart cart=this.getCart();
		CartLine cartLine= cartLineDAO.getbyCartAndProduct(cart.getId(), productId);	
		
		if(cartLine==null)
		{
			
			//add a new cartline
			cartLine = new CartLine();
			
			//fetch product
			Product product=productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			return "result=added";
			
		}
		
		else
		{
			//check if cart line has reached maxmimun count
			if(cartLine.getProductCount() < 3)
			{
				
				//update product count for cartline
				response=this.updateCartLine(cartLine.getId(),cartLine.getProductCount() + 1);
				
				
			}
			else
			{	
				return "result=maximum";	
			}
			
		}
				return null;
	}

	public String deleteCartLine(int cartLineId) 
	{
	
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null)
		{
			return "result=error";
		}
		else
		{
			//update cart
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove cart line
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
		}
		
	}


}
