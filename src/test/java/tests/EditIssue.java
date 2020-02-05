package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class EditIssue extends BaseTest {
    private JiraLoginPage dashboard = new JiraLoginPage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);

    private String testIssue = "MTP-1043";
    private String oldTitle = "Edit issue works?";
    private String newTitle = "Edit test";

    @Test
    void editIssueAndCancel() {
        dashboard.navigateToLoginPage();
        dashboard.loginWithCredentials("user15", VALID_PW);

        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.editSummaryField(newTitle);
        issuePage.cancelEditIssue();

        issuePage.navigateToIssue(testIssue);
        String currentTitle = issuePage.getIssueSummaryText();
        Assertions.assertEquals(oldTitle, currentTitle);
    }
}
