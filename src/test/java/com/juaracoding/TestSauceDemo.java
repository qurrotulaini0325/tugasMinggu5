package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddToCartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSauceDemo {
    static WebDriver driver;
    LoginPage loginPage;
    AddToCartPage addToCartPage;
    CheckoutPage checkoutPage;
    LogoutPage logoutPage;

    @BeforeClass
    public void main(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://saucedemo.com/");
        loginPage = new LoginPage();
        addToCartPage = new AddToCartPage();
        checkoutPage = new CheckoutPage();
        logoutPage = new LogoutPage();
    }

    @Test(priority = 1)
    public void loginWrongUsername(){
        loginPage.login("ai", "standard_user");
        Assert.assertEquals(loginPage.errorTxt(),"Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void loginNoUser(){
        loginPage.login("", "secret_user");
        Assert.assertEquals(loginPage.errorTxt(),"Epic sadface: Username is required");
        driver.navigate().refresh();
    }

    @Test(priority = 3)
    public void loginNoPassword(){
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.errorTxt(),"Epic sadface: Password is required");
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    public void loginValid(){
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(loginPage.loginTxt(),"Products");
    }

    @Test(priority = 5)
    public void addCart(){
        addToCartPage.addCart();
    }

    @Test(priority = 6)
    public void checkoutNoFirstName(){
        checkoutPage.checkout("","ai","0134");
        Assert.assertEquals(checkoutPage.txtErrorCheckout(),"Error: First Name is required");
        driver.navigate().refresh();
    }

    @Test(priority = 7)
    public void checkoutNoLastName(){
        checkoutPage.checkout("ai","","0134");
        Assert.assertEquals(checkoutPage.txtErrorCheckout(),"Error: Last Name is required");
        driver.navigate().refresh();
    }

    @Test(priority = 8)
    public void checkoutNoPost(){
        checkoutPage.checkout("qur","ai","");
        Assert.assertEquals(checkoutPage.txtErrorCheckout(),"Error: Postal Code is required");
        driver.navigate().refresh();
    }

    @Test(priority = 9)
    public void checkoutValid(){
        checkoutPage.checkout("qur","aii","0325");
        checkoutPage.finish();
        Assert.assertEquals(checkoutPage.txtValidCheckout(),"Thank you for your order!");
    }

    @Test(priority = 10)
    public void logout(){
        logoutPage.logout();
    }

    @AfterClass
    public void close(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}