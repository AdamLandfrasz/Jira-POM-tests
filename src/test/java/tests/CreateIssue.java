package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.JiraCreateIssuePage;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class CreateIssue extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraCreateIssuePage createIssueWindow = new JiraCreateIssuePage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);

    @Test
    void createIssue() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.setSummary(summary);
        createIssueWindow.submitIssue();

        issuePage.clickIssuePopup();
        String issueSummaryText = issuePage.getIssueSummaryText();
        String issueTypeText = issuePage.getIssueTypeText();
        issuePage.deleteIssue();

        Assertions.assertEquals(summary, issueSummaryText);
        Assertions.assertEquals(issueType, issueTypeText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/specific-create.csv")
    void createIssueForSpecificProject(String user, String project, String issueType) {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(user, VALID_PW);
        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.cancelIssueCreation();
    }

    @Test
    void cancelledIssueCreation() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.setSummary(summary);
        createIssueWindow.cancelIssueCreation();

    }
}
