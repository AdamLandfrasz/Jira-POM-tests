package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    final String VALID_PW = System.getenv("password");
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5000);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {driver.quit();}
    }
}
