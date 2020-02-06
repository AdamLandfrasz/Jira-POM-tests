package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
