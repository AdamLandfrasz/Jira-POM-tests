package pages;

import okio.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class JiraIssuePage extends BasePage {
    @FindBy(xpath = "//a[@id=\"key-val\"]")
    private WebElement issueTitleLink;
    @FindBy(xpath = "//h1[@id=\"summary-val\"]")
    private WebElement issueSummary;
    @FindBy(xpath = "//span[@id=\"type-val\"]")
    private WebElement issueType;
    @FindBy(xpath = "//a[@id=\"opsbar-operations_more\"]")
    private WebElement moreDropdown;
    @FindBy(xpath = "//*[@id=\"delete-issue\"]//a")
    private WebElement deleteOption;
    @FindBy(xpath = "//*[@id=\"create-subtask\"]//a")
    private WebElement createSubTask;

    @FindBy(xpath = "//input[@id=\"delete-issue-submit\"]")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@id=\"aui-flag-container\"]/div/div/a")
    private WebElement issuePopupLink;

    @FindBy(xpath = "//*[@id=\"view-subtasks\"]//*[@id=\"issuetable\"]//a")
    private WebElement subTaskSummary;

    @FindBy(xpath = "//a[@id=\"edit-issue\"]")
    private WebElement editIssueButton;
    @FindBy(xpath = "//*[@id=\"qf-field-picker-trigger\"]")
    private WebElement configureFieldsButton;
    @FindBy(xpath = "//div[@id='inline-dialog-field_picker_popup']//dd[text()='All']")
    private WebElement optionAll;
    @FindBy(xpath = "//*[@id=\"summary\"]")
    private WebElement summaryField;
    @FindBy(xpath = "//*[@id=\"edit-issue-dialog\"]/div[2]/div[1]/div/form/div[2]/div/a")
    private WebElement cancelButton;
    @FindBy(xpath = "//*[@id=\"edit-issue-submit\"]")
    private WebElement updateIssueButton;
    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div")
    private WebElement updateIssueFlag;
    @FindBy(xpath = "//*[@id=\"edit-issue-dialog\"]/div[2]/div[1]/div/form/div[1]/div/div[1]/div")
    private WebElement summaryFieldErrorMsg;

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
        wait.until(ExpectedConditions.visibilityOf(deleteOption));
        wait.until(ExpectedConditions.elementToBeClickable(deleteOption)).click();
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteButton)).click();
    }

    public void openSubTaskDialog() {
        moreDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(createSubTask)).click();
    }

    public String getSubTaskSummaryText() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(subTaskSummary)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void clickEditIssueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editIssueButton));
        editIssueButton.click();
        clickConfigureFieldsButton();
    }

    public void clickConfigureFieldsButton() {
        By configureFieldsButtonXpath = By.xpath("//*[@id=\"qf-field-picker-trigger\"]");
        By optionAllXpath = By.xpath("//div[@id='inline-dialog-field_picker_popup']//dd[text()='All']");

        wait.until(ExpectedConditions.presenceOfElementLocated(configureFieldsButtonXpath));
        configureFieldsButton.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(optionAllXpath)).click();
        }
        catch(ElementNotInteractableException ignored) {}
    }

    public void editSummaryField(String title) {
        wait.until(ExpectedConditions.visibilityOf(summaryField));
        summaryField.click();
        summaryField.clear();
        summaryField.sendKeys(title);
    }

    public void cancelEditIssue() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
        driver.switchTo().alert().accept();
    }

    public void updateIssue() {
        updateIssueButton.click();
        try {
            updateIssueFlag.isDisplayed();
        }
        catch (NoSuchElementException e) {
            try {
                wait.until(ExpectedConditions.visibilityOf(updateIssueFlag));
            }
            catch (TimeoutException ignored) {}
        }
    }

    public void resetTestIssue(String title) {
        clickEditIssueButton();
        editSummaryField(title);
        updateIssue();
    }

    public void saveEmpty() {
        wait.until(ExpectedConditions.visibilityOf(summaryField));
        summaryField.click();
        summaryField.clear();
        updateIssueButton.click();
    }

    public boolean isErrorMsgCorrect() {
        wait.until(ExpectedConditions.visibilityOf(summaryFieldErrorMsg));
        return summaryFieldErrorMsg.getText().equals("You must specify a summary of the issue.");
    }

    public boolean isEditIssueButtonAvailable() {
        try {
            return editIssueButton.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
