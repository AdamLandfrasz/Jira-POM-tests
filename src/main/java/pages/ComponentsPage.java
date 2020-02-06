package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentsPage extends BasePage {
    // Constructor
    public ComponentsPage(WebDriver driver) {
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

    @FindBy(xpath = "//*[@id=\"leadUserName-single-select\"]")
    private WebElement LeadOptionalSingleSelect;

    @FindBy(xpath = "//*[@id=\"components-add__component\"]/div[3]/input")
    private WebElement DescriptionOptionalInputField;

    @FindBy(xpath = "//*[@id=\"assigneeType-single-select\"]")
    private WebElement ComponentLeadSingleSelect;

    @FindBy(xpath = "//*[@id=\"components-add__component\"]/div[5]/button")
    private WebElement AddComponentButton;


}
