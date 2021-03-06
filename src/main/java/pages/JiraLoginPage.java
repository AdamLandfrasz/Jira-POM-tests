package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(xpath = "//p[contains(text(), \"please try again\")]")
    private WebElement errorMsg;

    public JiraLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToLoginPage() {
        navigateToUrl("login.jsp");
    }

    public void loginWithCredentials(String username, String password) {
        usernameInputField.sendKeys(username);
        usernameInputField.sendKeys(Keys.TAB);
        passwordInputField.sendKeys(password);
        passwordInputField.sendKeys(Keys.TAB);
        loginButton.click();
    }

    public boolean isErrorPresent() {
        try {
            return errorMsg.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getErrorMsgText() {
        return errorMsg.getText();
    }

    public void validLogin() {
        loginWithCredentials("user15", System.getenv("default_pw"));
    }
}
