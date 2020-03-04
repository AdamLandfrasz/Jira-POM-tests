package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class JiraComponentsPage extends BasePage {
    // Constructor
    public JiraComponentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    // HTML elements
    @FindBy(xpath = "//*[@id=\"sidebar-page-container\"]/header/div/h1")
    private WebElement pageTitle;
    @FindBy(xpath = "//*[@id=\"add_component\"]")
    private WebElement ManageComponentsButton;
    @FindBy(xpath = "//*[@id=\"components-add__component\"]/div[1]/input")
    private WebElement ComponentNameInputField;
    //*[@id="project-config-components-table"]/tbody[1]/tr/td[2]
    @FindBy(xpath = "//*[@id=\"leadUserName-single-select\"]")
    private WebElement LeadOptionalSingleSelect;
    @FindBy(xpath = "//*[@id=\"components-add__component\"]/div[3]/input")
    private WebElement DescriptionOptionalInputField;
    @FindBy(xpath = "//*[@id=\"assigneeType-single-select\"]")
    private WebElement ComponentLeadSingleSelect;
    @FindBy(xpath = "//*[@id=\"components-add__component\"]/div[5]/button")
    private WebElement AddComponentButton;
    @FindBy(xpath = "//*[@id=\"components-table\"]/tbody/tr[@data-component-id='10524']/td[1]")
    private WebElement testComponentInTheTable;
    @FindBy(xpath = "//*[@id=\"components-table\"]")
    private WebElement ComponentsTable;
    @FindBy(xpath = "//*[@id=\"project-config-panel-components\"]")
    private WebElement ComponentsPanel;
    @FindBy(xpath = "//*[@id=\"project-config-components-table\"]/tbody[1]/tr/td[2]/input[1]")
    private WebElement NameInputField;
    @FindBy(xpath = "//*[@id=\"project-config-components-table\"]/tbody[1]/tr/td[5]/select")
    private WebElement DefaultAssigneeSingleSelect;
    @FindBy(xpath = "//*[@id=\"project-config-components-table\"]/tbody[1]/tr/td[6]/input")
    private WebElement AddButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[1]/nav/div/div[2]/ul/li[6]/a/span[1]")
    private WebElement ComponentsIcon;
    @FindBy(xpath = "//*[@id=\"content-container\"]")
    private WebElement contentContainer;
    @FindBy(xpath = "//*[@id=\"component-filter-text\"]")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"components-table\"]/tbody[2]/tr/td[1]/div/a")
    private WebElement searchResult;
    @FindBy(xpath = "//*[@id=\"components-table\"]/tbody[2]/tr/td[6]/div/a/span")
    private WebElement actionsDotDot;
    @FindBy(xpath = "//*[@id=\"deletecomponent_11014\"]")
    private WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement finalDeleteButton;

    // Methods
    public void navigateToTestProject() {
        navigateToUrl("projects/PP1?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page");
    }

    public String getTestComponent() {
        By component = By.xpath("//*[@id=\"components-table\"]/tbody/tr[@data-component-id='10524']/td[1]");
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(component)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void addNewComponent(String testName) {
        ManageComponentsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(NameInputField));
        NameInputField.sendKeys(testName);
        Select defaultAssignee = new Select(DefaultAssigneeSingleSelect);
        defaultAssignee.selectByVisibleText("Unassigned");
        AddButton.click();
    }

    // not finished
    public void checkIfNewlyAddedComponentIsVisible(String testName) {
        ComponentsIcon.click();
        wait.until(ExpectedConditions.visibilityOf(contentContainer));
        searchField.sendKeys(testName);
        wait.until(ExpectedConditions.visibilityOf(searchResult));
    }

    public void deleteTestComponent() {
        //actionsDotDot.click();
        driver.findElement(By.linkText("..."));
        driver.findElement(By.linkText("Delete")).click();
        /*wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();*/
        //wait.until(ExpectedConditions.elementToBeClickable(finalDeleteButton));
        //finalDeleteButton.click();

    }

}
