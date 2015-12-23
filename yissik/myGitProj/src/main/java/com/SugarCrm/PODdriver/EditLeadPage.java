package com.SugarCrm.PODdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditLeadPage extends BasePage{

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

    @FindBy(linkText = "Edit")
    private WebElement editBtn;

    EditLeadPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void editFirstName(String firstName) {

        this.firstName.clear();
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

    public SumNewLead submitChanges() {
        submitButton.click();

        return new SumNewLead(driver);
    }

    public EditLeadPage editLead() {
        editBtn.click();
        return new EditLeadPage(driver);
    }
}
