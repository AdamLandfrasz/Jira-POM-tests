package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JiraCreateIssuePage;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class CreateIssue extends BaseTest {
    private JiraLoginPage dashboard = new JiraLoginPage(driver);
    private JiraCreateIssuePage createIssueWindow = new JiraCreateIssuePage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);

    @Test
    void createIssue() {
        String project = "MTP";
        String issueType = "Task";
        String summary = String.valueOf(System.currentTimeMillis());

        dashboard.navigateToLoginPage();
        dashboard.loginWithCredentials("user15", VALID_PW);

        createIssueWindow.clickCreateIssue();
        createIssueWindow.setProjectValue(project);
        createIssueWindow.setIssueTypeValue(issueType);
        createIssueWindow.setSummary(summary);
        createIssueWindow.submitIssue();

        issuePage.clickIssuePopup();
        Assertions.assertEquals(summary, issuePage.getIssueSummaryText());
        Assertions.assertEquals(issueType, issuePage.getIssueTypeText());
        issuePage.deleteIssue();
    }

}
