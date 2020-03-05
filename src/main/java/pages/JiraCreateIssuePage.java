package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraCreateIssuePage extends BasePage {
    @FindBy(xpath = "//a[@id=\"create_link\"]")
    private WebElement createNavButton;
    @FindBy(xpath = "//div[@id=\"create-issue-dialog\"]")
    private WebElement issueCreateDialog;
    @FindBy(xpath = "//*[@id=\"create-subtask-dialog\"]")
    private WebElement createSubTaskDialog;

    @FindBy(xpath = "//input[@id=\"project-field\"]")
    private WebElement projectField;
    private By projectFieldXpath = By.xpath("//input[@id=\"project-field\"]");
    @FindBy(xpath = "//input[@id=\"issuetype-field\"]")
    private WebElement issueTypeField;
    private By issueTypeFieldXpath = By.xpath("//input[@id=\"issuetype-field\"]");
    @FindBy(xpath = "//input[@id=\"summary\"]")
    private WebElement summaryField;
    private By summaryFieldXpath = By.xpath("//input[@id=\"summary\"]");
    @FindBy(xpath = "//input[@id=\"create-issue-submit\"]")
    private WebElement submitIssueButton;
    @FindBy(xpath = "//input[@id=\"create-issue-submit\"]//following-sibling::a")
    private WebElement cancelButton;

    public JiraCreateIssuePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private void setIssueField(By fieldXpath, WebElement field, String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(fieldXpath));
        wait.until(ExpectedConditions.elementToBeClickable(field)).click();

        field.sendKeys(value);
        field.sendKeys(Keys.TAB);
    }

    public void clickCreateIssue() {
        wait.until(ExpectedConditions.elementToBeClickable(createNavButton)).click();
    }

    public void setProjectValue(String projectValue) {
        setIssueField(projectFieldXpath, projectField, projectValue);
        wait.until(ExpectedConditions.elementToBeClickable(issueCreateDialog));
    }

    public void setIssueTypeValue(String issueType) {
        setIssueField(issueTypeFieldXpath, issueTypeField, issueType);
        wait.until(ExpectedConditions.elementToBeClickable(issueCreateDialog));
    }

    public void setSummary(String summary) {
        setIssueField(summaryFieldXpath, summaryField, summary);
        wait.until(ExpectedConditions.elementToBeClickable(issueCreateDialog));
    }

    public void setSubTaskSummary(String summary) {
        setIssueField(summaryFieldXpath, summaryField, summary);
        wait.until(ExpectedConditions.elementToBeClickable(createSubTaskDialog));
    }

    public void submitIssue() {
        wait.until(ExpectedConditions.elementToBeClickable(submitIssueButton)).click();
    }

    private void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {
        }
    }

    public void cancelIssueCreation() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
        acceptAlert();
    }

    private String getIssueFieldValue(WebElement field) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(field)).getAttribute("value");
        } catch (NoSuchElementException e) {
            return null;
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.elementToBeClickable(field)).getAttribute("value");
        }
    }

    public String getProjectFieldValue() {
        return getIssueFieldValue(projectField);
    }

    public String getIssueTypeFieldValue() {
        return getIssueFieldValue(issueTypeField);
    }

}
