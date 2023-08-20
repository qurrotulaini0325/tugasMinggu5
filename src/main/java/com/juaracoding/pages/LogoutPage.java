package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="back-to-products")
    WebElement btnBack;

    @FindBy(id="react-burger-menu-btn")
    WebElement btnBurger;

    @FindBy(id="logout_sidebar_link")
    WebElement btnLogout;

    public void logout(){
        btnBack.click();
        btnBurger.click();
        btnLogout.click();
    }
}
