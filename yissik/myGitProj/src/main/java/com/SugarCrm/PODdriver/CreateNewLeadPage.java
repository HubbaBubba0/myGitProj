package com.SugarCrm.PODdriver;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.Select;

        import java.util.Date;

/**
 * Created by ninja on 22/12/15.
 */
public class CreateNewLeadPage {


    @FindBy(id = "first_name")
    private WebElement firstName;
    @FindBy(id = "last_name")
    private WebElement lastName;
    @FindBy(id = "salutation")
    private WebElement salutation;
    @FindBy(id = "SAVE_FOOTER")
    private WebElement submitButton;
    @FindBy(id = "alt_checkbox")
    private WebElement CopyAddressFromLeftCheckbox;

    private WebDriver driver;

    CreateNewLeadPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void enterSalutation(String salutation) {
        Select salutationDropdown = new Select(this.salutation);
        salutationDropdown.selectByVisibleText(salutation);
    }

    public void checkCopyAddressFromLeftCheckbox() {
        if ( !CopyAddressFromLeftCheckbox.isSelected() ) {
            CopyAddressFromLeftCheckbox.click();
        }
    }

    public SumNewLead submitNewLead() {
        submitButton.click();

        return new SumNewLead(driver);
    }
}
