package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    static final int TIMEOUT = Integer.parseInt(System.getenv("timeout"));
    static final String BASE_URL = System.getenv("base_url");
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, TIMEOUT);
    }

    void navigateToUrl(String urlPart) {
        driver.get(BASE_URL + urlPart);
    }
}
