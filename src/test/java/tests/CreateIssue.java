package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

public class CreateIssue extends BaseTest {
    private JiraDashboardPage dashboard = new JiraDashboardPage(driver);
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraCreateIssuePage createIssueWindow = new JiraCreateIssuePage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);
    private JiraSearchIssuesPage searchIssuesPage = new JiraSearchIssuesPage(driver);

    private void issueCreationProcess(String project, String issueType, String summary) {
        dashboard.navigateToDashboard();
        dashboard.loginFromDashboard("user15", VALID_PW);
        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.setSummary(summary);
        createIssueWindow.submitIssue();
    }

    @Test
    void createIssue() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        issueCreationProcess(project, issueType, summary);
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
        dashboard.navigateToDashboard();
        dashboard.loginFromDashboard(user, VALID_PW);
        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);

        String projectFieldValue = createIssueWindow.getProjectFieldValue();
        String issueTypeValue = createIssueWindow.getIssueTypeFieldValue();

        createIssueWindow.cancelIssueCreation();
        dashboard.logout();

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
        Assertions.assertTrue(searchIssuesPage.areNoIssuesPresent());
    }

    @Test
    void createSubTask() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        issueCreationProcess(project, issueType, summary);
        issuePage.clickIssuePopup();
    }
}
