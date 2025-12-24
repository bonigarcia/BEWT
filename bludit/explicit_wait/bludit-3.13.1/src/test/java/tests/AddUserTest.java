package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.UsersPage;

public class AddUserTest extends BaseTest {
	
	@Test
	public void addUser() {
		UsersPage users = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.users()
			.addUser()
			.setUsername("usertest")
			.setPassword("usertest123")
			.confirmPassword("usertest123")
			.setEmail("user@test.com")
			.setRole("Administrator")
			.save();
		
		assertEquals("usertest", users.getSecondUserName());
	}
	
}
