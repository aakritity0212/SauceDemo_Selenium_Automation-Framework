package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
	WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}

	By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
	By removeBtn = By.id("remove-sauce-labs-backpack");
	By cartIcon = By.className("shopping_cart_link");
	By cartBadge = By.className("shopping_cart_badge");

	public void addProductToCart() {
		driver.findElement(addToCartBtn).click();
	}

	public void removeProduct() {
		driver.findElement(removeBtn).click();
	}

	public void openCart() {
		driver.findElement(cartIcon).click();
	}

	public String getCartCount() {
		return driver.findElement(cartBadge).getText();
	}

}
