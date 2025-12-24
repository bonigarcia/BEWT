package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.seljup.Options;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class BaseTest {

    public WebDriver driver;
    protected static final String password = "e2eW3Bt3s71nGB3nchM4rK";
    protected static final String username = "admin";

    @Options
    ChromeOptions options = new ChromeOptions();
    {
        options.addArguments("--disable-search-engine-choice-screen",
                "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
        options.setBrowserVersion("127");
    }

    @BeforeEach
    public void setUp(WebDriver driver) {
        this.driver = driver;
        // setupNativeBrowser();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:8080/admin");
    }

//    public void setupNativeBrowser() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-search-engine-choice-screen",
//                "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
//        options.setBrowserVersion("127");
//        driver = new ChromeDriver(options);
//    }
//
//    public void setupRemoteWebdriver() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--no-sandbox", "--headless=new",
//                "--disable-gpu", "--screen-info={1920x1080}");
//        try {
//            driver = new RemoteWebDriver(
//                    new URL("http://localhost:4444/wd/hub"), chromeOptions);
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
