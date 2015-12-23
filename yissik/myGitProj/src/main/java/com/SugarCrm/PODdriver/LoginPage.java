package com.SugarCrm.PODdriver;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

/**
 * Created by ninja on 22/12/15.
 */
public class LoginPage extends BasePage {
    @FindBy(name = "user_name")
    private WebElement userNameBox;
    @FindBy(name = "user_password")
    private WebElement passwordBox;


    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillinNameBox(String userName) {
        userNameBox.sendKeys(userName);
    }

    public void fillinPassword(String userPassword) {
        passwordBox.sendKeys(userPassword);
    }

    public void loginSubmit() {
        passwordBox.submit();
    }

    public HomePage fillinAndSubmit(String userName, String userPassword) {
        fillinNameBox(userName);
        fillinPassword(userPassword);
        loginSubmit();

        return new HomePage(driver);
    }
}