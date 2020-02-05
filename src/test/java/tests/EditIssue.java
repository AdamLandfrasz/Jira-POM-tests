package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class EditIssue extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);

    private String testIssue = "MTP-1043";
    private String oldTitle = "Edit issue works?";
    private String newTitle = "Edit test";

    @BeforeEach
    public void login() {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);
    }

    @Test
    void editIssueAndCancel() {
        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.editSummaryField(newTitle);
        issuePage.cancelEditIssue();

        issuePage.navigateToIssue(testIssue);

        Assertions.assertEquals(oldTitle, issuePage.getIssueSummaryText());
    }

    @Test
    void editIssueAndSave() {
        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.editSummaryField(newTitle);
        issuePage.updateIssue();

        Assertions.assertEquals(newTitle, issuePage.getIssueSummaryText());

        issuePage.resetTestIssue(oldTitle);
    }

    @Test
    void editIssueWithEmpty() {
        issuePage.navigateToIssue(testIssue);
        issuePage.clickEditIssueButton();
        issuePage.saveEmpty();

        Assertions.assertTrue(issuePage.correctErrorMsg());
    }
}
