package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected static final String VALID_PW = System.getenv("default_pw");
    protected static final String BROWSER = System.getenv("browser");
    protected static WebDriver driver;

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        String gridURL = "https://selenium:" + VALID_PW + "@seleniumhub.codecool.codecanvas.hu/wd/hub";
        MutableCapabilities options = null;
        switch (BROWSER) {
            case "chrome":
                options = new ChromeOptions();
                break;
            case "firefox":
                options = new FirefoxOptions();
                break;
        }
        driver = new RemoteWebDriver(new URL(gridURL), options);
        driver.manage().window().maximize();
    }

    @AfterAll
    protected static void tearDown() {
        if (driver != null) {driver.quit();}
    }
}
