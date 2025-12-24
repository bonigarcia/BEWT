package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.ContentPage;

public class AddContentTest extends BaseTest {
	
	@Test
	public void addContentTest() {
		ContentPage content = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.newContent()
				.setTitle("Test Content")
				.saveAndReturnToContentPage();
		
		assertEquals("Test Content", content.getFirstContentTitle("Test Content"));
	}
}