package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.LanguagePage;

public class ChangeLanguageTest extends BaseTest {
	
	@Test
	public void changeLanguage() {
		LanguagePage lang = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.general()
			.language()
			.setLanguage("Italiano (Italia)")
			.save();
		
		assertEquals("Italiano (Italia)", lang.getLanguage());
		lang = lang.setLanguage("English").save();
		assertEquals("English", lang.getLanguage());
	}
	
}