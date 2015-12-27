package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends DashBoardPage {

    @FindBy(id = "liBFOATL")
    private WebElement addNewTaskBtn;

    private WebElement TasksListElement;

    TasksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        // Check that we're on the right page.
        if (!(isElementFound(By.xpath("//*[@id='pageTitle' and text()='Tasks']")))) {
            throw new IllegalStateException("This is not the Tasks page");
        }
    }

    public NewTaskListPage clickAddTaskBtn() {
        //click new task button
        addNewTaskBtn.click();

        //return new task list page
        return new NewTaskListPage(driver);
    }

    public TasksListPage createNewTaskList(String uniqueListName) {
        return new TasksListPage(uniqueListName, driver);
    }

    public boolean isListFound(String uniqueListName) {
        if (isElementFound(By.xpath("//*[@id='pageTitle' and text()='Tasks']"))) {
            return true;
        }
        return false;
    }

//    private void findListByName(String listName) {
//        WebElement newListElement = driver.findElement(By.xpath("//*[contains(text(), '" + listName + "')]/.."));
////        return textElement.findElement(By.xpath("//.."));
//        tasksListPage = new TasksListPage(listName, driver);
//    }

//    public AddNewTaskToListPage findListByNameAndClickAddNewTaskButton(String uniqueListName) {
////        setCurrentListPage(uniqueListName);
////        WebElement newListElement = ;
//        TasksListElement = driver.findElement(By.xpath("//a[contains(text(), '" + uniqueListName + "')]/../.."));
//        addNewTaskBtn = TasksListElement.findElement(By.xpath("*//button"));
//        addNewTaskBtn.click();
//        return new AddNewTaskToListPage(driver);
//    }

//    public void setCurrentListPage(String uniqueListName) {
//        tasksListPage = new AddNewTaskToListPage(driver);
//
//    }
}
