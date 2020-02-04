package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraProjectPage extends BasePage {


    public JiraProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToProjectPage(String project) {
        navigateToUrl("projects/" + project);
    }

    public boolean isGivenProjectKeyPresent(String projectKey){

        try{
            return driver.findElement(By.xpath("//*[@id=\"summary-body\"]//dd[text()=\"" + projectKey + "\"]")).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

//    public boolean isGivenUsernamePresent(String username){
//
//        try{
//            return driver.findElement(By.xpath("//*[@id=\"up-d-username\"]")).isDisplayed();
//        }catch (NoSuchElementException e){
//            return false;
//        }
//    }
}
