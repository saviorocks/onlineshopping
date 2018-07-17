package niit.com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.model.Address;
import com.niit.shoppingbackend.model.Cart;
import com.niit.shoppingbackend.model.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	
	/*@Test
	public void  testAdd()
	{
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		//user.setEnabled(true);
		user.setPassword("12345");
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link user with address using user id
		address.setUserId(user.getId());
		
		//add address
		assertEquals("Failed to add address", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			//create cart
			cart = new Cart();
			
			cart.setUser(user);
			
			assertEquals("Failed to add to cart", true, userDAO.addCart(cart));
			
			//add shipping address
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
			
			//link with user
			address.setUserId(user.getId());
			
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		}*/
	
	
	/*@Test
	public void  testAdd()
	{
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		//user.setEnabled(true);
		user.setPassword("12345");
		
		
		if(user.getRole().equals("USER"))
		{
			//create cart
			cart = new Cart();
			
			cart.setUser(user);
			
			//address.attach cart with user
			user.setCart(cart);
			
		}
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));
	}*/

	@Test
	public void testUpdateCart()
	{
		//fetch user by email
		user = userDAO.getByEmail("hr@gmail.com");
		
		//get the cart of the user
		cart = user.getCart();
		
		cart.setGrandTotal(555);
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart", true, userDAO.updateCart(cart));
		
	}
	
}
