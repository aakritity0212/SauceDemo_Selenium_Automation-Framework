package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTests extends BaseTest{
	
	@Test
    public void addProductToCartTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addProductToCart();

        Assert.assertEquals(
                inventoryPage.getCartCount(),
                "1");

        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertTrue(
                cartPage.isProductDisplayed());
    }

}
