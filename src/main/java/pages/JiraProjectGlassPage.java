package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class JiraProjectGlassPage extends BasePage {
    @FindBy(xpath = "//a[@data-link-id=\"com.codecanvas.glass:glass\"]")
    private WebElement glassDocumentationLink;
    @FindBy(xpath = "//*[@id=\"glass-permissions-panel\"]//thead//th")
    private List<WebElement> permissionsTableHeader;


    public JiraProjectGlassPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnPermissionsTab(){
        By xpath = By.xpath("//*[@id=\"glass-permissions-nav\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath)).click();
    }

    public boolean getGivenPermissionValue(String permissionType, String permissionValue) {

        int resultHeaderIndex;

        WebElement permissionTypeElement = driver.findElement(By.xpath("//tbody//tr[descendant-or-self::b[text()=\"" + permissionType+ "\"]]"));
        WebElement resultHeader = driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]//thead//th[descendant-or-self::b[contains(text(),\"" + permissionValue + "\")]]"));

        resultHeaderIndex = permissionsTableHeader.indexOf(resultHeader);

        List<WebElement> permissionValueElements = permissionTypeElement.findElements(By.tagName("td"));

        return null != permissionValueElements.get(resultHeaderIndex).findElement(By.className("glass-true-icon"));
    }

}
