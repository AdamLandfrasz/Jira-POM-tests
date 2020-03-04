package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    static final String BASE_URL = "https://jira.codecool.codecanvas.hu/";
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Integer.parseInt(System.getenv("timeout")));
    }

    void navigateToUrl(String urlPart) {
        driver.get(BASE_URL + urlPart);
    }
}
