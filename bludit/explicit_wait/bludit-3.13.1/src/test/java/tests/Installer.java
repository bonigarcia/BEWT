package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import po.AdminLogin;
import po.UsersPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Installer extends BaseTest {
	
	@Test
	public void install() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("jspassword")).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
	}
	
}
