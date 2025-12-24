package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.UsersPage;

public class DeleteUserTest extends BaseTest {
	
	@Test
	public void deleteUser() {
		UsersPage users = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.users()
			.editSecondUser()
			.security()
			.delete();
		
		assertFalse(users.containsUser("usertest"));
	}
}