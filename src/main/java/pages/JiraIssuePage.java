package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraIssuePage extends BasePage {
    @FindBy(xpath = "//a[@id=\"key-val\"]")
    private WebElement issueTitleLink;
    @FindBy(xpath = "//h1[@id=\"summary-val\"]")
    private WebElement issueSummary;
    @FindBy(xpath = "//span[@id=\"type-val\"]")
    private WebElement issueType;
    @FindBy(xpath = "//a[@id=\"opsbar-operations_more\"]")
    private WebElement moreDropdown;
    @FindBy(xpath = "//*[@id=\"delete-issue\"]")
    private WebElement deleteOption;

    @FindBy(xpath = "//div[@id=\"aui-flag-container\"]/div/div/a")
    private WebElement issuePopupLink;

    @FindBy(xpath = "//input[@id=\"delete-issue-submit\"]")
    private WebElement confirmDeleteButton;

    public JiraIssuePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToIssue(String issue) {
        navigateToUrl("browse/" + issue);
    }

    public boolean isIssueNamePresent() {
        try {
            return issueTitleLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getIssueNameText() {
        try {
            return issueTitleLink.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getIssueSummaryText() {
        try {
            return issueSummary.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getIssueTypeText() {
        try {
            return issueType.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void clickIssuePopup() {
        wait.until(ExpectedConditions.elementToBeClickable(issuePopupLink)).click();
    }

    public void deleteIssue() {
        moreDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
}
