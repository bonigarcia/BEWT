package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.UsersPage;

public class DisableUserTest extends BaseTest {
	
	@Test
	public void disableUser() {
		UsersPage users = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.users()
				.editSecondUser()
				.security()
				.disable();
		assertEquals("Disabled", users.getSecondUserAbilitation());
	}
}
