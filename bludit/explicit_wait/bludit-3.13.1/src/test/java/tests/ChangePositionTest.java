package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.NewContentPage;

public class ChangePositionTest extends BaseTest {
	
	@Test
	public void changePosition() {
		NewContentPage contentPage = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.content()
			.editFirstContent()
			.options()
			.advanced()
			.setPosition("30")
			.options()
			.saveAndStay()
			.options()
			.advanced();
		
		assertEquals("30", contentPage.getPosition());
	}
}
