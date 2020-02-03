package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    static final String BASE_URL = "https://jira.codecool.codecanvas.hu/";
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void navigateToUrl(String urlPart) {
        driver.get(BASE_URL + urlPart);
    }
}
