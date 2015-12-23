package com.SugarCrm.PODdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ninja on 22/12/15.
 */
public class MenuBar extends BasePage{
    @FindBy(linkText = "Sales")
    private WebElement salesLink;

//    SubMenu sales = ;
//    SubMenu marketing;
//    SubMenu support;
//    SubMenu activities;
//    SubMenu collaboration;
//    SubMenu all;

    MenuBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

//    public SubMenu clickMenuItem(String menuItemName) {
//
//        return new SubMenu(menuItemName);
//    }

    public SubMenu clickSales() {
        salesLink.click();
        return new SubMenu(driver);
    }
    public LeadsPage navigateToSalesLeadsPage() {

        SubMenu sb = clickSales();
//        sb.clickSubMenuLeads();

        return sb.clickSubMenuLeads();
    }


}
