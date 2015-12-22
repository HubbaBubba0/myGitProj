package com.SugarCrm.PODdriver;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

/**
 * Created by ninja on 22/12/15.
 */
public class HomePage {

    @FindBy(linkText = "Sales")
    private WebElement salesLink;
    @FindBy(linkText = "Leads")
    private WebElement leadsLink;
    private WebDriver driver;

    HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LeadsPage navigateToLeadsPage() {
        salesLink.click();
        leadsLink.click();

        return new LeadsPage(driver);
    }
}