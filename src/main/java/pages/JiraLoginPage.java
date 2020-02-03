package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JiraLoginPage extends BasePage{
    @FindBy(xpath = "//input[@id=\"login-form-username\"]")
    private WebElement usernameInputField;
    @FindBy(xpath = "//input[@id=\"login-form-password\"]")
    private WebElement passwordInputField;
    @FindBy(xpath = "//input[@id=\"login-form-submit\"]")
    private WebElement loginButton;

    public JiraLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToLoginPage() {
        navigateToUrl("login.jsp");
    }

    public void loginWithCredentials(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }
}
