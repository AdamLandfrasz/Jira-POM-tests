package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraUserProfilePage extends BasePage{
    private By usernameDataField = By.xpath("//*[@id=\"up-d-username\"]");

    public JiraUserProfilePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProfilePage() {
        navigateToUrl("/secure/ViewProfile.jspa");
    }

    public String getUsernameText() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(usernameDataField)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
