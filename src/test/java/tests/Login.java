package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.JiraLoginPage;
import pages.JiraUserProfilePage;

public class Login extends BaseTest{
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraUserProfilePage userPage = new JiraUserProfilePage(driver);

    @ParameterizedTest
    @ValueSource(strings = {"user14", "user15", "user16"})
    void successfulLogin(String username) {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials(username, System.getenv("password"));
        userPage.navigateToProfilePage();
        Assertions.assertEquals(username, userPage.getUsernameText());
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
}
