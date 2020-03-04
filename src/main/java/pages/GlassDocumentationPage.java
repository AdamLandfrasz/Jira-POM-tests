package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class GlassDocumentationPage extends BasePage {
    // Constructor
    public GlassDocumentationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    // HTML elements
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[1]/nav/div/div[2]/ul/li[7]/a/span[2]")
    private WebElement GlassDocumentationMenuOnNavbar;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[1]/nav/div/div[2]/ul/li[7]/a/span[1]")
    private WebElement GlassDocumentationMenuIconOnNavbar;

    @FindBy(xpath = "//*[@id=\"aui-uid-1\"]")
    private WebElement ComponentsTab;

    @FindBy(xpath = "//*[@id=\"components-table\"]/tbody/tr[@data-component-id='10524']/td[1]")
    private WebElement testComponentInTheList;

    @FindBy(xpath = "//*[@id=\"components-table\"]")
    private WebElement ComponentsList;

    // Methods
    public void navigateToTestProject() {
        navigateToUrl("projects/PP1?selectedItem=com.codecanvas.glass:glass");
        ComponentsTab.click();
    }

    public String getTestComponent() {
        By component = By.xpath("//*[@id=\"components-table\"]/tbody/tr[@data-component-id='10524']/td[1]");
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(component)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
