package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//a[@id=\"create_link\"]")
    private WebElement createButton;
    @FindBy(xpath = "//*[@id=\"create-issue-dialog\"]")
    private WebElement createIssueDialog;
    @FindBy(xpath = "//a[@id=\"header-details-user-fullname\"]")
    private WebElement profileLink;
    @FindBy(xpath = "//a[@id=\"log_out\"]")
    private WebElement logOut;

    public JiraDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickViewAllProjects() {
        projectsNavElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProjects)).click();
    }

    public void clickSearchIssues() {
        issuesNavElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchForIssues)).click();
    }

    public void clickCreateIssue() {
        By createIssueWindow = By.xpath("//*[@id=\"create-issue-dialog\"]");

        createButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createIssueWindow));
    }
}
