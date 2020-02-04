package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JiraIssuePage extends BasePage {
    @FindBy(xpath = "//a[@id=\"key-val\"]")
    private WebElement issueTitleLink;

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
        return issueTitleLink.getText();
    }
}
