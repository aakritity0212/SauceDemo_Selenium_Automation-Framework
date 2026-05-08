package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTests extends BaseTest{
	
	@Test
    public void completeCheckoutTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addProductToCart();

        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterCheckoutInfo(
                "Subhasis",
                "Pal",
                "700001");

        checkoutPage.clickContinue();

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        overviewPage.clickFinish();

        Assert.assertEquals(
                overviewPage.getSuccessMessage(),
                "Thank you for your order!");
    }

}
