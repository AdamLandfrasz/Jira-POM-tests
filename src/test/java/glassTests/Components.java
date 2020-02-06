package glassTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JiraComponentsPage;
import pages.GlassDocumentationPage;
import pages.JiraLoginPage;
import tests.BaseTest;

import javax.print.attribute.standard.PresentationDirection;

public class Components extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraComponentsPage jiraComponentsPage = new JiraComponentsPage(driver);
    private GlassDocumentationPage glassDocPage = new GlassDocumentationPage(driver);

    @Test
    void compareComponentsAndGlassDocumentation() {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        jiraComponentsPage.navigateToTestProject();
        String testComponentOnComponents = jiraComponentsPage.getTestComponent();
        glassDocPage.navigateToTestProject();
        String testComponentInGlassDoc = glassDocPage.getTestComponent();

        Assertions.assertEquals(testComponentOnComponents, testComponentInGlassDoc);
    }

    // not finished
    /*@Test
    void addingNewComponent() {
        String testName = "testName";

        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", VALID_PW);

        jiraComponentsPage.navigateToTestProject();
        jiraComponentsPage.addNewComponent(testName);
        jiraComponentsPage.checkIfNewlyAddedComponentIsVisible(testName);
        //Assertions.assertTrue(jiraComponentsPage.checkIfNewlyAddedComponentIsVisible(testName));

        jiraComponentsPage.deleteTestComponent();

    }*/
}
