package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraCreateIssuePage extends BasePage{
    @FindBy(xpath = "//a[@id=\"create_link\"]")
    private WebElement createNavButton;
    @FindBy(xpath = "//div[@id=\"create-issue-dialog\"]")
    private WebElement issueCreateDialog;

    @FindBy(xpath = "//input[@id=\"project-field\"]")
    private WebElement projectField;
    @FindBy(xpath = "//input[@id=\"issuetype-field\"]")
    private WebElement issueTypeField;
    @FindBy(xpath = "//input[@id=\"summary\"]")
    private WebElement summaryField;
    @FindBy(xpath = "//input[@id=\"create-issue-submit\"]")
    private WebElement submitIssueButton;
    @FindBy(xpath = "//input[@id=\"create-issue-submit\"]//following-sibling::a")
    private WebElement cancelButton;

    public JiraCreateIssuePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private void setIssueField(WebElement field, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(field)).click();
        field.sendKeys(value);
        field.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(issueCreateDialog));
    }

    public void clickCreateIssue() {
        wait.until(ExpectedConditions.elementToBeClickable(createNavButton)).click();
    }

    public void setProjectValue(String projectValue) {
        setIssueField(projectField, projectValue);
    }

    public void setIssueTypeValue(String issueType) {
        setIssueField(issueTypeField, issueType);
    }

    public void setSummary(String summary) {
        setIssueField(summaryField, summary);
    }

    public void submitIssue() {
        submitIssueButton.click();
    }

    private void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored){}
    }

    public void cancelIssueCreation() {
        cancelButton.click();
        acceptAlert();
    }

    private String getIssueFieldValue(WebElement field) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(field)).getAttribute("value");
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getProjectFieldValue() {
        return getIssueFieldValue(projectField);
    }

    public String getIssueTypeFieldValue() {
        return getIssueFieldValue(issueTypeField);
    }

}
