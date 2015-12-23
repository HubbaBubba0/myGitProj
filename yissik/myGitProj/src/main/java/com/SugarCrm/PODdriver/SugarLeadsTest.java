package com.SugarCrm.PODdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SugarLeadsTest {
    private WebDriver driver;
    private String userName = "admin";
    private String userPassword = "admin";


    public HomePage login(String userName, String userPassword) {

        LoginPage loginPage = new LoginPage(driver);
        return loginPage.fillinAndSubmit(userName, userPassword);
    }

    private Map createUniqueLeadDetails() {
        int randomizingCounter = 0;
        Date date = new Date(System.currentTimeMillis());
        String firstName = "" + randomizingCounter++ + date.getTime();
        String lastName = "" + randomizingCounter++ + date.getTime();
        String[] salutations = {
                "Mr.", "Prof.", "Mrs.", "Ms."
        };

//        int randomNumber = (int) Math.random() * 3;
        String salutation = salutations[(int) Math.random() * 3];

        Map details = new HashMap();

        details.put("firstName", firstName);
        details.put("lastName", lastName);
        details.put("salutation", salutation);

        return details;
    }
    @BeforeMethod
    public void startUp() {
        // Create a new instance of the Chrome driver and a webDriverWait
        System.setProperty("webdriver.chrome.driver", "/home/ninja/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Go to sugar crm
        driver.get("http://localhost/sugar/SugarCE-Full-6.5.22/index.php?action=Login&module=Users");

    }

    @Test
    public void createLeadTest() {
        //Login
        HomePage homePage = login(userName, userPassword);

        //navigate to leads page
        LeadsPage leadsPage = homePage.navigateToSalesLeadsPage();

        //Create Lead
        CreateNewLeadPage createNewLeadPage = leadsPage.navigateToCreateNewLeadPage();


        //New Lead

        //create unique first and last names
        String firstName = (String) createUniqueLeadDetails().get("firstName");
        String lastName = (String) createUniqueLeadDetails().get("lastName");
        String salutation = (String) createUniqueLeadDetails().get("salutation");

        //fill in form
        createNewLeadPage.enterFirstName(firstName);
        createNewLeadPage.enterLastName(lastName);
        createNewLeadPage.enterSalutation(salutation);
        createNewLeadPage.checkCopyAddressFromLeftCheckbox();
        createNewLeadPage.submitNewLead();

        //navigate to leads page
        leadsPage = leadsPage.navigateToSalesLeadsPage();

        //search for the created user
        leadsPage.searchUser(lastName);
        leadsPage.isSearchUserFound(lastName);

        //Close the browser
        driver.quit();
    }

    @Test
    public void editLeadTest() {

        //Login
        HomePage homePage = login(userName, userPassword);

        //navigate to leads page
        LeadsPage leadsPage = homePage.navigateToSalesLeadsPage();

        //Create Lead
        CreateNewLeadPage createNewLeadPage = leadsPage.navigateToCreateNewLeadPage();

        //create unique first and last names
        String firstName = (String) createUniqueLeadDetails().get("firstName");
        String lastName = (String) createUniqueLeadDetails().get("lastName");
        String salutation = (String) createUniqueLeadDetails().get("salutation");

        //fill in form
        createNewLeadPage.enterFirstName(firstName);
        createNewLeadPage.enterLastName(lastName);
        createNewLeadPage.enterSalutation(salutation);
        createNewLeadPage.checkCopyAddressFromLeftCheckbox();
        createNewLeadPage.submitNewLead();

        //navigate to leads page
        leadsPage = leadsPage.navigateToSalesLeadsPage();

        //search for the created user and click it
        leadsPage.searchUser(lastName);
//        if (leadsPage.isSearchUserFound(lastName)) {
        EditLeadPage editLeadPage = leadsPage.navigateToEditLeadPage(lastName);
//        }

        //click the edit button
        editLeadPage.editLead();
        editLeadPage.editFirstName(firstName + 1);
        editLeadPage.submitChanges();

        //Close the browser
        driver.quit();
    }

}
