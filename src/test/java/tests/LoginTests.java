package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest{
	
	@Test
    public void validLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("inventory"));
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "wrong_user",
                "wrong_pass");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password"));
    }

}
