package com.SugarCrm.PODdriver;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.Assert;

        import java.util.LinkedList;
        import java.util.List;

public class LeadsPage  {

    @FindBy(xpath = "//a/span[text()='Create Lead']")
    private WebElement createLeadLink;
    @FindBy(linkText = "Sales")
    private WebElement salesLink;
    @FindBy(linkText = "Leads")
    private WebElement leadsLink;
    @FindBy(id = "search_name_basic")
    private WebElement searchNameBox;

    private List<WebElement> searchLastNameText = new LinkedList();
    private WebDriver driver;

    LeadsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateNewLeadPage navigateToCreateNewLeadPage() {
        createLeadLink.click();

        return new CreateNewLeadPage(driver);
    }

    public LeadsPage navigateToLeadsPage() {

        salesLink.click();
        leadsLink.click();

        return new LeadsPage(driver);
    }

    public void searchUser(String lastName) {
        searchNameBox.clear();
        searchNameBox.sendKeys(lastName);
        searchNameBox.submit();
    }

    public void isSearchUserFound(String lastName) {
//        boolean isFound = searchLastNameText.size() > 0;
        searchLastNameText = driver.findElements(By.xpath("//*[contains(text(),'" + lastName + "')]"));
        Assert.assertFalse(searchLastNameText.isEmpty());

    }
}