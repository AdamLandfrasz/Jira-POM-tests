package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.JiraIssuePage;
import pages.JiraLoginPage;

public class BrowseIssues extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/specific-issues.csv")
    void browseSpecificIssues(String username, String issue) {
        JiraLoginPage loginPage = new JiraLoginPage(driver);
        JiraIssuePage issuePage = new JiraIssuePage(driver);

        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(username, VALID_PW);
        issuePage.navigateToIssue(issue);
        Assertions.assertTrue(issuePage.isIssueNamePresent());
        Assertions.assertEquals(issue, issuePage.getIssueNameText());
    }
}
