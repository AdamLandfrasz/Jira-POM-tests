package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraProjectPermissionsPage extends BasePage {
    @FindBy(xpath = "//a[@data-link-id=\"com.codecanvas.glass:glass\"]")
    private WebElement glassDocumentationLink;


    public JiraProjectPermissionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void goToProjectPermissionsPage(){
        driver.get("https://jira.codecool.codecanvas.hu/plugins/servlet/project-config/PP4/permissions");
    }

    public String getGivenPermissionTypeValue(String permissionType){
        By resultRowXPath = By.xpath("//*[@id=\"project-config-panel-permissions\"]//tr[@data-permission-key=\"" + permissionType + "\"]");

        WebElement resultRowElement = driver.findElement(resultRowXPath);

        return resultRowElement.findElement(By.tagName("dd")).getText();
    }

    public void navigateToGlassDocumentation(){
        glassDocumentationLink.click();
    }
}
