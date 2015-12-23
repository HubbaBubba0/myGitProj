package com.SugarCrm.PODdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.LinkedList;
import java.util.List;

public class LeadsPage extends BasePage {

    @FindBy(xpath = "//a/span[text()='Create Lead']")
    private WebElement createLeadLink;
    @FindBy(linkText = "Sales")
    private WebElement salesLink;
    @FindBy(linkText = "Leads")
    private WebElement leadsLink;
    @FindBy(id = "search_name_basic")
    private WebElement searchNameBox;

    private List<WebElement> searchLastNameText = new LinkedList();

    MenuBar menuBar;


    LeadsPage(WebDriver driver) {
        super(driver);
        menuBar = new MenuBar(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateNewLeadPage navigateToCreateNewLeadPage() {
        createLeadLink.click();
        return new CreateNewLeadPage(driver);
    }

    public EditLeadPage navigateToEditLeadPage(String lastName) {
        getUserByLastName(lastName).get(0).click();
        return new EditLeadPage(driver);
    }

    public LeadsPage navigateToSalesLeadsPage() {

//        SubMenu sb = menuBar.clickSales();
//        sb.clickSubMenuLeads();
//
//        return new LeadsPage(driver);

        return menuBar.navigateToSalesLeadsPage();
    }

    public void searchUser(String lastName) {
        searchNameBox.clear();
        searchNameBox.sendKeys(lastName);
        searchNameBox.submit();
    }

    public List<WebElement> getUserByLastName(String lastName) {
        return driver.findElements(By.xpath("//*[contains(text(),'" + lastName + "')]"));

    }

    public boolean isSearchUserFound(String lastName) {
        searchLastNameText = getUserByLastName(lastName);
        boolean isFound = !searchLastNameText.isEmpty();
        Assert.assertTrue(isFound);

        return isFound;
    }
//
//    public EditLeadPage navigateToEditLeadPage() {
//        menuBar.navigateToSalesLeadsPage();
//        return null;
//    }
}