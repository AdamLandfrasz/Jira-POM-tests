package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JiraUserProfilePage extends BasePage{
    @FindBy(xpath = "//*[@id=\"up-d-username\"]")
    private WebElement usernameDataField;

    public JiraUserProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToProfilePage() {
        navigateToUrl("/secure/ViewProfile.jspa");
    }

    public String getUsernameText() {
        return usernameDataField.getText();
    }
}
