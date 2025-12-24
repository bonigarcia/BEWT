package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import po.AdminLogin;

public class BadLoginFailsTest extends BaseTest {
	
	@Test
	public void badLogin_Fails() {
		AdminLogin login = new AdminLogin(driver)
				.setUsername(username)
				.setPassword("wrongpassword")
				.badLogin();
		
		assertTrue(login.isAlertVisible());
		assertEquals("Username or password incorrect", login.getAlertText());
	}
}