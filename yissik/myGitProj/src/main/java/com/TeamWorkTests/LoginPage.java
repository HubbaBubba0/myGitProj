package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(name = "userLogin")
    private WebElement userNameBox;
    @FindBy(name = "password")
    private WebElement passwordBox;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        //check that we are on the login page
        if (!isElementFound(By.id("ordLoginSubmitBtn"))) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void fillinNameBox(String userName) {
        userNameBox.sendKeys(userName);
    }

    public void fillinPassword(String userPassword) {
        passwordBox.sendKeys(userPassword);
    }

    public void loginSubmit() {
        passwordBox.submit();
    }

    public HomePage fillinAndSubmit(String userName, String userPassword) {
        fillinNameBox(userName);
        fillinPassword(userPassword);
        loginSubmit();

        return new HomePage(driver);
    }
}
