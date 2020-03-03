package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected static final String VALID_PW = System.getProperty("default_pw");
    protected static WebDriver driver;

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
//        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        String gridURL = "https://selenium:" + VALID_PW + "@seleniumhub.codecool.codecanvas.hu/wd/hub";
        driver = new RemoteWebDriver(new URL(gridURL), options);
        driver.manage().window().maximize();
    }

    @AfterAll
    protected static void tearDown() {
        if (driver != null) {driver.quit();}
    }
}
