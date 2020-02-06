package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraProjectPermissionsPage extends BasePage {
    @FindBy(xpath = "//tr[@data-permission-key=\"BROWSE_PROJECTS\"]//dd");
    private WebElement browseProjetsRowValueElement;
    @FindBy(xpath = "//a[@data-link-id=\"com.codecanvas.glass:glass\"]");
    private WebElement glassDocumentationLink;


    public JiraProjectPermissionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void goToProjectPermissionPage(String projectKey){
        navigateToUrl("/plugins/servlet/project-config/" + "" + "permissions");
    }

    public void goToProjectGlassDocumentation(){

    }
}
