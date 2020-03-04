package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

public class TestCreateIssue extends BaseTest {
    private JiraDashboardPage dashboard = new JiraDashboardPage(driver);
    private JiraCreateIssuePage createIssueWindow = new JiraCreateIssuePage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);
    private JiraSearchIssuesPage searchIssuesPage = new JiraSearchIssuesPage(driver);

    private void doIssueCreation(String project, String issueType, String summary) {
        dashboard.navigateToDashboard();
        dashboard.loginFromDashboard("user15", VALID_PW);
        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.setSummary(summary);
        createIssueWindow.submitIssue();
    }

    @AfterEach
    void tearDownAfterEach() {
        dashboard.logout();
    }

    @Test
    void createIssue() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        doIssueCreation(project, issueType, summary);
        issuePage.clickIssuePopup();
        String issueSummaryText = issuePage.getIssueSummaryText();
        String issueTypeText = issuePage.getIssueTypeText();
        issuePage.deleteIssue();

        Assertions.assertEquals(summary, issueSummaryText);
        Assertions.assertEquals(issueType, issueTypeText);
    }

    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/specific-create.csv")
    void createIssueForSpecificProject(String user, String project, String issueType) {
        dashboard.navigateToDashboard();
        dashboard.loginFromDashboard(user, VALID_PW);
        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);

        String projectFieldValue = createIssueWindow.getProjectFieldValue();
        String issueTypeValue = createIssueWindow.getIssueTypeFieldValue();

        createIssueWindow.cancelIssueCreation();

        Assertions.assertTrue(projectFieldValue.contains(project));
        Assertions.assertEquals(issueType, issueTypeValue);
    }

    @Test
    void cancelledIssueCreation() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        dashboard.navigateToDashboard();
        dashboard.loginFromDashboard("user15", VALID_PW);

        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.setSummary(summary);
        createIssueWindow.cancelIssueCreation();

        dashboard.navigateToSearchIssues();
        searchIssuesPage.inputToSearchBar("summary ~ \"" + summary + "\"");
        boolean noIssuesArePresent = searchIssuesPage.areNoIssuesPresent();
        Assertions.assertTrue(noIssuesArePresent);
    }

    @Test
    void createSubTask() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        doIssueCreation(project, issueType, summary);
        issuePage.clickIssuePopup();
        issuePage.openSubTaskDialog();
        createIssueWindow.setSubTaskSummary(summary);
        createIssueWindow.submitIssue();

        String subTaskSummaryValue = issuePage.getSubTaskSummaryText();
        issuePage.deleteIssue();
        Assertions.assertEquals(summary, subTaskSummaryValue);
    }
}
