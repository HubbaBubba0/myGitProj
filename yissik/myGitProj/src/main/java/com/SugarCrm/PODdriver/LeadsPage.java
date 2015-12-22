package com.SugarCrm.PODdriver;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

public class LeadsPage  {

    @FindBy(xpath = "//a/span[text()='Create Lead']")
    private WebElement createLeadLink;
    private WebDriver driver;

    LeadsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateNewLeadPage navigateToCreateNewLeadPage() {
        createLeadLink.click();

        return new CreateNewLeadPage(driver);
    }
}