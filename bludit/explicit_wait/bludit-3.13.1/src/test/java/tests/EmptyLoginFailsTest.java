package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import po.AdminLogin;

public class EmptyLoginFailsTest extends BaseTest {
	
	@Test
	public void emptyLogin_Fails() {
		AdminLogin login = new AdminLogin(driver)
				.setUsername("")
				.setPassword("")
				.badLogin();
		
		assertTrue(login.isAlertVisible());
		assertEquals("Username or password incorrect", login.getAlertText());
	}
}
