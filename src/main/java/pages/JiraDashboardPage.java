package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraDashboardPage extends BasePage {
    @FindBy(xpath = "//a[@id=\"browse_link\"]")
    private WebElement projectsNavElement;
    @FindBy(xpath = "//a[@id=\"project_view_all_link_lnk\"]")
    private WebElement viewAllProjects;

    @FindBy(xpath = "//a[@id=\"find_link\"]")
    private WebElement issuesNavElement;
    @FindBy(xpath = "//a[@id=\"issues_new_search_link_lnk\"]")
    private WebElement searchForIssues;

    @FindBy(xpath = "//a[@id=\"header-details-user-fullname\"]")
    private WebElement profileLink;
    @FindBy(xpath = "//a[@id=\"log_out\"]")
    private WebElement logout;
    @FindBy(xpath = "//*[@id=\"user-options\"]//a")
    private WebElement logInNavButton;

    @FindBy(xpath = "//input[@name=\"os_username\"]")
    private WebElement usernameField;
    @FindBy(xpath = "//*[@name=\"os_password\"]")
    private WebElement passwordField;

    public JiraDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToDashboard() {
        navigateToUrl("secure/Dashboard.jspa");
    }

    public void navigateToViewAllProjects() {
        wait.until(ExpectedConditions.visibilityOf(projectsNavElement)).click();
        wait.until(ExpectedConditions.visibilityOf(viewAllProjects)).click();
    }

    public void navigateToSearchIssues() {
        navigateToUrl("issues/?jql=");
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }

    public boolean isLoginButtonPresent() {
        try {
            return logInNavButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void loginFromDashboard(String username, String pw) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);
        usernameField.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(pw);
        passwordField.sendKeys(Keys.TAB);
        passwordField.submit();
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
    }
}
