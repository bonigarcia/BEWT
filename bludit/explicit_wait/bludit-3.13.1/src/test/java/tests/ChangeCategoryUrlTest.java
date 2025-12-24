package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.CategoriesPage;

public class ChangeCategoryUrlTest extends BaseTest {
	
	@Test
	public void changeCategoryUrl() {

		CategoriesPage categories = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.categories()
				.editCategory("Category001")
				.setUrl("aaanewurl001")
				.save();
		
		assertEquals("/category/aaanewurl001", categories.getFirstCategoryUrl());
				
	}
}
