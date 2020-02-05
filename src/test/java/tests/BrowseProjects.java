package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

public class BrowseProjects extends BaseTest {
    private JiraDashboardPage dashboardPage = new JiraDashboardPage(driver);
    private JiraBrowseProjectsPage browseProjectsPage = new JiraBrowseProjectsPage(driver);
    private JiraProjectPage projectPage = new JiraProjectPage(driver);
    private JiraLoginPage loginPage = new JiraLoginPage(driver);

    @Disabled
    @Test
    void navigateToMTPSummaryPage(){

        browseProjectsPage.navigateToMTPSummaryPage();
        Assertions.assertTrue(projectPage.isGivenProjectKeyPresent("MTP"));
    }

    @Disabled
    @Test
    void navigateToAdministratorPage(){

        browseProjectsPage.navigateToAdministratorUserPage();
        //Assertions.assertTrue(projectPage.);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/specific-projects.csv")
    void browseSpecificProjects(String username, String project) {

        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(username, VALID_PW);
        browseProjectsPage.goToProject(project);
        Assertions.assertTrue(projectPage.isGivenProjectKeyPresent(project));
    }

}