package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;
import tests.BaseTest;

public class Permissions extends BaseTest {
    private JiraLoginPage loginPage = new JiraLoginPage(driver);
    private JiraDashboardPage dashboardPage = new JiraDashboardPage(driver);
    private JiraProjectPermissionsPage projectPermissionsPage = new JiraProjectPermissionsPage(driver);
    private JiraProjectGlassPage projectGlassPage = new JiraProjectGlassPage(driver);

    @Test
    void browseProjectsPermissions(){
        final String permissionType = "Browse Projects";
        final String permissionDataAttribute = "BROWSE_PROJECTS";

        loginPage.navigateToLoginPage();
        loginPage.validLogin();
        projectPermissionsPage.goToProjectPermissionsPage();
        String expectedPermissionValue = projectPermissionsPage.getGivenPermissionTypeValue(permissionDataAttribute);
        projectPermissionsPage.navigateToGlassDocumentation();
        projectGlassPage.clickOnPermissionsTab();
        Assertions.assertTrue(projectGlassPage.getGivenPermissionValue(permissionType, expectedPermissionValue));
    }

    @Test
    void editIssuePermissions(){
        final String permissionType = "Create Issues";
        final String permissionDataAttribute = "CREATE_ISSUES";

        loginPage.navigateToLoginPage();
        loginPage.validLogin();
        projectPermissionsPage.goToProjectPermissionsPage();
        String expectedPermissionValue = projectPermissionsPage.getGivenPermissionTypeValue(permissionDataAttribute);
        projectPermissionsPage.navigateToGlassDocumentation();
        projectGlassPage.clickOnPermissionsTab();
        Assertions.assertTrue(projectGlassPage.getGivenPermissionValue(permissionType, expectedPermissionValue));
    }

    @Test
    void createIssuePermissions(){
        final String permissionType = "Edit Issues";
        final String permissionDataAttribute = "EDIT_ISSUES";

        loginPage.navigateToLoginPage();
        loginPage.validLogin();
        projectPermissionsPage.goToProjectPermissionsPage();
        String expectedPermissionValue = projectPermissionsPage.getGivenPermissionTypeValue(permissionDataAttribute);
        projectPermissionsPage.navigateToGlassDocumentation();
        projectGlassPage.clickOnPermissionsTab();
        Assertions.assertTrue(projectGlassPage.getGivenPermissionValue(permissionType, expectedPermissionValue));
    }
}
