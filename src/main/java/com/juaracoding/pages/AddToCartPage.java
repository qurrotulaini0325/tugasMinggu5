package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
    private WebDriver driver;

    public AddToCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement btnProduct1;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement btnProduct2;

    @FindBy(className="shopping_cart_link")
    WebElement btnCart;

    @FindBy(id="checkout")
    WebElement btnCheckout;

    public void addCart(){
        btnProduct1.click();
        btnProduct2.click();
        btnCart.click();
        btnCheckout.click();
    }
}
