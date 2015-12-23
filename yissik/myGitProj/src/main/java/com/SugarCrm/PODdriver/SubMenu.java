package com.SugarCrm.PODdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubMenu extends BasePage {
    @FindBy(linkText = "Leads")
    private WebElement leadsLink;



    SubMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LeadsPage clickSubMenuLeads() {
        leadsLink.click();
        return new LeadsPage(driver);
    }
}
