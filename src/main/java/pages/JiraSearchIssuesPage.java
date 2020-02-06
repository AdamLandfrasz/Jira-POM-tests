package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraSearchIssuesPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"advanced-search\"]")
    private WebElement issueSearchField;
    @FindBy(xpath = "//button[text()=\"Search\"]")
    private WebElement searchButton;
    @FindBy(xpath = "//button[text()=\"Save as\"]")
    private WebElement saveAsButton;
    @FindBy(xpath = "//h2[contains(text(),\"No issues were found\")]")
    private WebElement noIssuesMsg;

    public JiraSearchIssuesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void inputToSearchBar(String searchPhrase) {
        issueSearchField.sendKeys(searchPhrase);
        searchButton.click();
    }

    public boolean areNoIssuesPresent() {
        wait.until(ExpectedConditions.elementToBeClickable(saveAsButton));
        try {
            return noIssuesMsg.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
