package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import po.AdminLogin;
import po.StickyPage;

public class SetStickyPostTest extends BaseTest {
	
	@Test
	public void setStickyPost() {
		StickyPage sticky = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.content()
			.editThirdContent()
			.options()
			.advanced()
			.setPostType("Sticky")
			.options()
			.saveAndStay()
			.content()
			.sticky();
		assertEquals("Set up your new site", sticky.getFirstStickyTitle());
	}
	
}
