package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static final String VALID_PW = System.getenv("password");
    protected static WebDriver driver;

    @BeforeAll
    protected static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    protected static void tearDown() {
        if (driver != null) {driver.quit();}
    }
}
