package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class NegativeTests extends BaseTest{
	
	@Test(priority = 1)
    public void invalidUsernameTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "wrong_user",
                "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password"));
    }

    @Test(priority = 2)
    public void invalidPasswordTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "wrong_password");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password"));
    }

    @Test(priority = 3)
    public void emptyUsernameTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "",
                "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username is required"));
    }

    @Test(priority = 4)
    public void emptyPasswordTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Password is required"));
    }

    @Test(priority = 5)
    public void emptyCredentialsTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "",
                "");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username is required"));
    }

}
