package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.AdvancedSettingsPage;

public class ChangeHomeTest extends BaseTest {
	
	@Test
	public void changeHome() {
		AdvancedSettingsPage settings = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.general()
			.advanced()
			.setHome("Create your own content")
			.save();
		assertEquals("Create your own content", settings.getSelectedHome());
	}
	
}