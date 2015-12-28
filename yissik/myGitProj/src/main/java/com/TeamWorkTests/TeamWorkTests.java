package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ContextConfiguration(locations = { "classpath:bean.xml" })
public class TeamWorkTests extends AbstractTestNGSpringContextTests {

    //instanciate with bean
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

//        Setup setup = (Setup) context.getBean("Setup");
//        WebDriverFactory webDriverFactory = (WebDriverFactory) context.getBean("WebDriverFactory");

    WebDriver driver;

    @Autowired
    Setup setup;
    @Autowired
    WebDriverFactory webDriverFactory;

    public HomePage login() {

        LoginPage loginPage = new LoginPage(driver);
        return loginPage.fillinAndSubmit(setup.getDefaultUser(), setup.getDefaultPassword());
    }

    private String createUniqueListName(String prefix) {
        int randomizingCounter = 0;
        Date date = new Date(System.currentTimeMillis());
        String listName = prefix + "_" + randomizingCounter++ + date.getTime();

        return listName;
    }

//    @BeforeMethod
//    public void startUp() {
//        // Create a new instance of the Chrome driver and a webDriverWait
//        System.setProperty("webdriver.chrome.driver", "/home/ninja/Downloads/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        // Go to sugar crm
//        driver.get("https://topq.teamwork.com");
//
//    }

    @BeforeMethod
    public void startUpWithBean() {

        System.out.println(webDriverFactory.getDriverLocation() + "\n" + webDriverFactory.getDriverType());

        // Create a new instance of the Chrome driver and a webDriverWait
        if(webDriverFactory.getDriverType().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", webDriverFactory.getDriverLocation());
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(webDriverFactory.getImplicitWait()), TimeUnit.SECONDS);

        // Go to sugar crm
        driver.get(setup.getUrl());
    }

    @Test
    public void loginAndTasksTest() throws InterruptedException {
        //login
        HomePage homePage = login();
        //go to dashboard tab
        DashBoardPage dashBoardPage = homePage.navigateToDashboard();
//        OverviewPage overviewPage = dashBoardPage.navigateToOverviewTab();
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
//        TasksListPage listPage = tasksPage.findListByName(uniqueListName);

//        AddNewTaskToListPage addNewTaskToListPage = listPage.findListByNameAndClickAddNewTaskButton();

        //add new task to existing task list
        TasksListPage listPage = tasksPage.createNewTaskList(uniqueListName);
        listPage.findListByNameAndClickAddNewTaskButton();

        String taskName = "taskush";
        listPage.enterTaskName(taskName);
        //assign to
        listPage.selectAssignTo("fake01");
        //submit task
        listPage.clickSaveChangesToTaskBtn();

        Thread.sleep(1000); //sleep for changes to take affect

        //add another task to existing task list
        //no need to find the task list to add to because it's the same list
//        listPage = tasksPage.createNewTaskList(uniqueListName);
//        listPage.findListByNameAndClickAddNewTaskButton();

        taskName = "taskush2";
        listPage.enterTaskName(taskName);
        //assign to
        listPage.selectAssignTo("fake02");
        //submit task
        listPage.clickSaveChangesToTaskBtn();

        //navigate to milestone page tab
        MilestonePage milestonePage = dashBoardPage.navigateToMilestoneTab();
        Thread.sleep(1000); //sleep for changes to take affect
        tasksPage = dashBoardPage.navigateToTasksPage();

        //make sure task list and its tasks still exist
        boolean listFound = tasksPage.isListFound(uniqueListName);
        if(listFound) {
            System.out.println("Task list " + uniqueListName + " found, with " + listPage.numOfTasks() + " tasks in the list");

        } else {
            System.out.println("Task list " + uniqueListName + " NOT found");
        }

        listPage.deleteList();

        driver.quit();
    }

    @Test
    public void HelloWorldBeanTest() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

        obj.getMessage();


    }


    @Test
    public void addMilestoneTest() throws InterruptedException {

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
        String uniqueListName = createUniqueListName("r2d23poob1");
        //type the unique name to text box
        newTaskListPage.enterListName(uniqueListName);
        //submit
        tasksPage = newTaskListPage.clickAddTaskList();

        MilestonePage milestonePage = dashBoardPage.navigateToMilestoneTab();
        AddNewMilestonePage addNewMilestonePage = milestonePage.clickAddNewMileStoneBtn();
        String uniquemilestoneName = createUniqueListName("significantMilestone");
        milestonePage = addNewMilestonePage.enterMilestoneNameAndSubmit(uniquemilestoneName);
        milestonePage.hoverOverMilestone(uniquemilestoneName);
//        milestonePage.attachMilestoneToTask(uniquemilestoneName);

    }

//
//    @Test
//    public void deleteAllLists() throws InterruptedException {
//        //login
//        HomePage homePage = login();
//        //go to dashboard tab
//        DashBoardPage dashBoardPage = homePage.navigateToDashboard();
////        OverviewPage overviewPage = dashBoardPage.navigateToOverviewTab();
//        //go to tasks tab
//        Thread.sleep(3000); //webpage bug??
//        TasksPage tasksPage = dashBoardPage.navigateToTasksPage();
//
//        List<WebElement> allTasks = driver.findElements(By.xpath("//li[@class='currentTaskListsItem']"));
//
//        for (int i=0; i<10; i++) {
//            allTasks.get(i).click();
//            String currentUrl = driver.getCurrentUrl();
//            String[] splitCurrentUrl = currentUrl.split("\\/");
//            currentUrl = splitCurrentUrl[splitCurrentUrl.length - 1];
//
//        }
//    }

}
