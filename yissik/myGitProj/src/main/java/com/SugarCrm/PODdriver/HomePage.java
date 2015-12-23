package com.SugarCrm.PODdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(linkText = "Sales")
    private WebElement salesLink;
    private WebDriver driver;

    MenuBar menuBar;

    HomePage(WebDriver driver) {
        super(driver);
        menuBar = new MenuBar(driver);
        PageFactory.initElements(driver, this);
    }

    public LeadsPage navigateToSalesLeadsPage() {
        return menuBar.navigateToSalesLeadsPage();
    }
}