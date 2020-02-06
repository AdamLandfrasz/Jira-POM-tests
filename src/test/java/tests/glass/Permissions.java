package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.JiraDashboardPage;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class Permissions extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraDashboardPage dashboardPage = new JiraDashboardPage(driver);

    @Test
    void browseProjectsPermissions(){

        loginPage.navigateToLoginPage();
        loginPage.validLogin();
    }

    @Test
    void createIssuePermissions(){
        loginPage.navigateToLoginPage();
        loginPage.validLogin();
    }

    @Test
    void editIssuePermissions(){
        loginPage.navigateToLoginPage();
        loginPage.validLogin();
    }

}
