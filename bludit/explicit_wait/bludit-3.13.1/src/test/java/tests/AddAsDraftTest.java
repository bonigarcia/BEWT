package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import po.AdminLogin;
import po.ContentPage;
import po.DraftPage;

public class AddAsDraftTest extends BaseTest {
	
	@Test
	public void addAsDraft() {
		ContentPage content = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.newContent()
				.setTitle("Draft Content")
				.setDraft()
				.saveAndReturnToContentPage();
		assertFalse(content.getFirstContentTitle().contains("Draft Content"));
		DraftPage drafts = content.drafts();
		assertEquals("Draft Content", drafts.getFirstDraftTitle("Draft Content"));
		
	}
}