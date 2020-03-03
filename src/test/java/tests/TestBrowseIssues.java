package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class TestBrowseIssues extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraIssuePage issuePage = new JiraIssuePage(driver);

    @ParameterizedTest
    @CsvFileSource(resources = "/specific-issues.csv")
    void browseSpecificIssues(String username, String issue) {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(username, VALID_PW);
        issuePage.navigateToIssue(issue);
        Assertions.assertTrue(issuePage.isIssueNamePresent());
        Assertions.assertEquals(issue, issuePage.getIssueNameText());
    }


}
