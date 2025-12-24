package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.ContentPage;

public class DeletePostTest extends BaseTest {
	
	@Test
	public void deletePost() {
		ContentPage content = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.content()
				.deleteThirdElement()
				.confirmDelete();
		assertFalse(content.containsElement("Follow Bludit"));
	}
	
}
