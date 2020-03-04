package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected static final String VALID_PW = System.getenv("default_pw");
    protected static final String BROWSER = System.getenv("browser");
    protected static final String GRID_URL = System.getenv("grid_url");
    protected static WebDriver driver;

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        String fullGridUrl = GRID_URL.replace("{PASSWORD}", VALID_PW);
        MutableCapabilities options = null;
        if ("chrome".equals(BROWSER)) {
            options = new ChromeOptions();
        } else if ("firefox".equals(BROWSER)) {
            options = new FirefoxOptions();
        }
        driver = new RemoteWebDriver(new URL(fullGridUrl), options);
//        if (BROWSER.equals("firefox")) {
//            driver = new FirefoxDriver();
//        } else {
//            driver = new ChromeDriver();
//        }
        driver.manage().window().maximize();
    }

    @AfterAll
    protected static void tearDown() {
        if (driver != null) {driver.quit();}
    }
}
