package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
	
	public WebDriver driver;
	public String appUrl = "http://127.0.0.1:3000";
	
	@Before
	public void setUp() {
	    setupNativeBrowser(); // setupRemoteWebdriver();
        driver.manage().window().maximize();
	}

	public void setupRemoteWebdriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", /*"--headless=new",*/ "--disable-gpu", "--screen-info={1920x1080}");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setupNativeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", /*"--headless=new",*/ "--disable-gpu", "--screen-info={1920x1080}");
		options.setBrowserVersion("127");
		driver = new ChromeDriver(options);
	}
	
	public void goToHome() {
		driver.get(appUrl);
	}
	
	public void goToAdminHome() {
		driver.get(appUrl+"/admin");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
