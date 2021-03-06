package niit.com.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.model.Category;

public class CategryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory() {

		category = new Category();

		category.setName("Air Conditioners");
		category.setDescription("This is some description for Air Conditioners!");
		category.setImageURL("CAT_4.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		
		
		assertEquals("Successfully fetched a single category from the table!","Mobile",category.getName());
		
		
	}*/

	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("Mob");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
	
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(3);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}*/
	
	/*@Test
	public void testListCategory() {
					
		assertEquals("Successfully fetched the list of categories from the table!",4,categoryDAO.list().size());
		
	}*/
	
	
	@Test
	public void testCRUDCategory() {
		
		/*// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("Television");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		*/
		
		/*//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",2,categoryDAO.list().size());		
		*/		
		
	}

	
}
