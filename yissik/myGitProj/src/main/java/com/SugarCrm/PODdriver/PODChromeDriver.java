package com.SugarCrm.PODdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PODChromeDriver {
    public static void main(String[] args) {

        String userName = "admin";
        String userPassword = "admin";

        // Create a new instance of the Chrome driver and a webDriverWait
        System.setProperty("webdriver.chrome.driver", "/home/ninja/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Go to sugar crm
        driver.get("http://localhost/sugar/SugarCE-Full-6.5.22/index.php?action=Login&module=Users");

        //Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.fillinAndSubmit(userName, userPassword);

        //navigate to leads page
        LeadsPage leadsPage = homePage.navigateToLeadsPage();

        //Create Lead
        CreateNewLeadPage createNewLeadPage = leadsPage.navigateToCreateNewLeadPage();


        //New Lead

        //create unique first and last names
        int randomizingCounter = 0;
        Date date = new Date(System.currentTimeMillis());
        String firstName = "" + randomizingCounter++ + date.getTime();
        String lastName = "" + randomizingCounter++ + date.getTime();
        String salutation = "Prof.";

        //fill in form

        //first name
        createNewLeadPage.enterFirstName(firstName);
        createNewLeadPage.enterLastName(lastName);
        createNewLeadPage.enterSalutation(salutation);
        createNewLeadPage.checkCopyAddressFromLeftCheckbox();
        createNewLeadPage.submitNewLead();

        //navigate to leads page
        leadsPage = leadsPage.navigateToLeadsPage();

        //search for the created user
        leadsPage.searchUser(lastName);
        leadsPage.isSearchUserFound(lastName);


//        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_name_basic")));
//        WebElement search_name_basic = driver.findElement(By.id("search_name_basic"));
//        search_name_basic.clear();
//        search_name_basic.sendKeys(lastName);
//        search_name_basic.submit();
//
//        //validate user appears in list
//        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MassUpdate")));
//        try {
//            driver.findElement(By.xpath("//*[contains(text(), lastName)]"));
//        } catch (ElementNotFoundException e){
//            Assert.assertTrue(true);
//        }
//
//        System.out.println("New user found");
//
//        //Close the browser
//        driver.quit();
//
////        driver.get();
    }
}