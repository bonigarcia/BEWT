package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.CategoriesPage;

public class AddCategoryTest extends BaseTest {
	
	@Test
	public void addCategory() {

		CategoriesPage categories = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.categories()
				.addCategory()
				.setName("Category001")
				.setDescr("Description001")
				.save();
		
		assertEquals("Category001", categories.getFirstCategoryName());
				
	}
	
}
