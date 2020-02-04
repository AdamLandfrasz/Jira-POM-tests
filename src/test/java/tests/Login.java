package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.JiraDashboardPage;
import pages.JiraLoginPage;
import pages.JiraUserProfilePage;

public class Login extends BaseTest{
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraDashboardPage dashboard = new JiraDashboardPage(driver);
    private JiraUserProfilePage userPage = new JiraUserProfilePage(driver);

    @ParameterizedTest
    @ValueSource(strings = {"user14", "user15", "user16"})
    void successfulLogin(String username) {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(username, VALID_PW);
        userPage.navigateToProfilePage();
        Assertions.assertEquals(username, userPage.getUsernameText());
    }

    @Test
    void successfulLoginDashboard() {
        dashboard.navigateToDashboard();
        dashboard.loginFromDashboard("user15", VALID_PW);
        userPage.navigateToProfilePage();
        Assertions.assertEquals("user15", userPage.getUsernameText());
    }

    @Test
    void invalidLogin() {
        String expectedErrorMsg = "Sorry, your username and password are incorrect - please try again.";

        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("user15", "invalid_pw!2020");
        Assertions.assertTrue(loginPage.isErrorPresent());
        Assertions.assertEquals(expectedErrorMsg, loginPage.getErrorMsgText());

        loginPage.validLogin();
    }

    @Test
    void logout() {
        loginPage.navigateToLoginPage();
        loginPage.validLogin();
        dashboard.logout();
        Assertions.assertTrue(dashboard.isLoginButtonPresent());
    }
}
