package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TeamWorkTests {
    private WebDriver driver;
    private String userName = "fake00@fake.com";
    private String userPassword = "fake";


    public HomePage login() {

        LoginPage loginPage = new LoginPage(driver);
        return loginPage.fillinAndSubmit(userName, userPassword);
    }

    private String createUniqueListName(String prefix) {
        int randomizingCounter = 0;
        Date date = new Date(System.currentTimeMillis());
        String listName = prefix + "_" + randomizingCounter++ + date.getTime();

        return listName;
    }

    @BeforeMethod
    public void startUp() {
        // Create a new instance of the Chrome driver and a webDriverWait
        System.setProperty("webdriver.chrome.driver", "/home/ninja/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Go to sugar crm
        driver.get("https://topq.teamwork.com");

    }

    @Test
    public void loginTest() throws InterruptedException {
        //login
        HomePage homePage = login();
        //go to dashboard tab
        DashBoardPage dashBoardPage = homePage.navigateToDashboard();
        //go to tasks tab
        Thread.sleep(3000); //webpage bug??
        TasksPage tasksPage = dashBoardPage.navigateToTasksPage();

        //add new list tasks
        NewTaskListPage newTaskListPage = tasksPage.clickAddTaskBtn();
        //create unique list name
        String uniqueListName = createUniqueListName("MeepMeep");
        //type the unique name to text box
        newTaskListPage.enterListName(uniqueListName);
        //submit
        tasksPage = newTaskListPage.clickAddTaskList();

        //find newly created list
//        WebElement newListElement = tasksPage.findListByName(uniqueListName);
        TasksListPage listPage = new TasksListPage(uniqueListName, driver);
//        TasksListPage listPage = tasksPage.findListByName(uniqueListName);
        listPage.clickAddNewTaskBtn();

//        AddNewTaskToListPage addNewTaskToListPage = listPage.clickAddNewTaskBtn();
        //add new task
        String taskName = "taskush";
        listPage.enterTaskName(taskName);
        //assign to
        listPage.selectAssignTo("fake01");
        //submit task
        listPage.clickSaveChangesToTaskBtn();

        //add another task
        listPage = new TasksListPage(uniqueListName, driver);
        taskName = "askush2";
        listPage.enterTaskName(taskName);
        //assign to
        listPage.selectAssignTo("fake02");
        //submit task
        listPage.clickSaveChangesToTaskBtn();
    }

}
