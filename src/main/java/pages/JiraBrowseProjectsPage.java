package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraBrowseProjectsPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"project-filter-text\"]")
    private WebElement projectsSearchBar;

    public JiraBrowseProjectsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void searchForMTP() {
        final String mtp = "main testing project";

        By firstProjectInList = By.xpath("//*[@id=\"projects\"]//a[text()=\"Main Testing Project\"]");

        projectsSearchBar.sendKeys(mtp);
        wait.until(ExpectedConditions.presenceOfElementLocated(firstProjectInList)).click();
    }

    public void navigateToMTPSummaryPage(){
        searchForMTP();

        By projectNameElement = By.xpath("//*[@id=\"content\"]//a");
        By projectKeyElement = By.xpath("By.xpath(\"//*[@id=\"summary-body\"]//dd[text()=\"MTP\"]");


        wait.until(ExpectedConditions.presenceOfElementLocated(projectNameElement)).click();
    }

    public void goToProject(String projectName) {

        navigateToUrl("projects/" + projectName);

        By projectNameElement = By.xpath("//*[@id=\"content\"]//a");

        wait.until(ExpectedConditions.elementToBeClickable(projectNameElement)).click();
    }

    public void navigateToAdministratorUserPage() {
        searchForMTP();

        By administrator = By.xpath("//*[@id=\"_jiraadmin\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(administrator)).click();
    }
}
