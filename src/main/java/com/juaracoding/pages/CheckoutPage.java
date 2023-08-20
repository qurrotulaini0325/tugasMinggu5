package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id="last-name")
    WebElement lastName;

    @FindBy(id="postal-code")
    WebElement postalCode;

    @FindBy(id="continue")
    WebElement btnContinue;

    @FindBy(id="finish")
    WebElement btnFinish;

    @FindBy(css = "h3[data-test='error']")
    WebElement txtError;

    @FindBy(className="complete-header")
    WebElement txtValid;

    public void checkout(String firstName, String lastName, String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
        btnContinue.click();
    }

    public void finish(){
        btnFinish.click();
    }
    public String txtValidCheckout(){
        return txtValid.getText();
    }

    public String txtErrorCheckout(){
        return txtError.getText();
    }
}