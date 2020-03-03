package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

public class TestBrowseProjects extends BaseTest {
    private JiraDashboardPage dashboardPage = new JiraDashboardPage(driver);
    private JiraBrowseProjectsPage browseProjectsPage = new JiraBrowseProjectsPage(driver);
    private JiraProjectPage projectPage = new JiraProjectPage(driver);
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraUserProfilePage profilePage = new JiraUserProfilePage(driver);

    @Test
    void navigateToMTPSummaryPage() {

        final String mtpKey = "MTP";

        loginPage.navigateToLoginPage();
        loginPage.validLogin();
        dashboardPage.navigateToViewAllProjects();
        browseProjectsPage.navigateToMTPSummaryPage();
        Assertions.assertTrue(projectPage.isGivenProjectKeyPresent(mtpKey));
    }

    @Test
    void navigateToAdministratorPage() {
        final String expectedUsername = "jiraadmin";

        loginPage.navigateToLoginPage();
        loginPage.validLogin();
        dashboardPage.navigateToViewAllProjects();
        browseProjectsPage.navigateToAdministratorUserPage();
        Assertions.assertEquals(expectedUsername, profilePage.getUsernameText());
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
