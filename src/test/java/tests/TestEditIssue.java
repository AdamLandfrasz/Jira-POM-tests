package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.JiraDashboardPage;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class TestEditIssue extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);
    private JiraDashboardPage dashboardPage = new JiraDashboardPage(driver);

    private String testIssue = "MTP-1043";
    private String oldTitle = "Edit issue works?";
    private String newTitle = "Edit test";

    @Test
    void editIssueAndCancel() {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.editSummaryField(newTitle);
        issuePage.cancelEditIssue();

        issuePage.navigateToIssue(testIssue);

        Assertions.assertEquals(oldTitle, issuePage.getIssueSummaryText());
    }

    @Test
    void editIssueAndSave() {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.editSummaryField(newTitle);
        issuePage.updateIssue();

        Assertions.assertEquals(newTitle, issuePage.getIssueSummaryText());

        issuePage.resetTestIssue(oldTitle);
    }

    @Test
    void editIssueWithEmpty() {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.saveEmpty();

        Assertions.assertTrue(issuePage.isErrorMsgCorrect());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/specific-issues.csv")
    void editSpecificIssue(String username, String issue) {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(username, VALID_PW);
        issuePage.navigateToIssue(issue);
        boolean editIssueButtonAvailable = issuePage.isEditIssueButtonAvailable();
        dashboardPage.logout();
        Assertions.assertTrue(editIssueButtonAvailable);
    }
}
