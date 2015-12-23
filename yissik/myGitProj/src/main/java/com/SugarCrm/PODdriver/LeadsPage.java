package com.SugarCrm.PODdriver;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.Assert;

public class LeadsPage  {

    @FindBy(xpath = "//a/span[text()='Create Lead']")
    private WebElement createLeadLink;
    @FindBy(linkText = "Sales")
    private WebElement salesLink;
    @FindBy(linkText = "Leads")
    private WebElement leadsLink;
    @FindBy(id = "search_name_basic")
    private WebElement searchNameBox;
    @FindBy(xpath = "//*[contains(text(), lastName)]")
    private WebElement searchLastNameText;
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

        //validate user appears in list
//        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MassUpdate")));
//        try {
//            driver.findElement(By.xpath("//*[contains(text(), lastName)]"));
//        } catch (ElementNotFoundException e){
//            Assert.assertTrue(true);
//        }
//
//        System.out.println("New user found");
    }

    public void isSearchUserFound(String lastName) {
        boolean isFound = searchLastNameText.equals(lastName);
    }
}