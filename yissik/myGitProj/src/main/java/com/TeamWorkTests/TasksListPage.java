package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TasksListPage extends BasePage {

//    WebElement listWebElement;
    String addTaskButtonText = "Add the first task";

    TasksListPage(String uniqueListName, WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
//        this.listWebElement = listWebElement;
    }

//    public TasksListPage(String uniqueListName) {
//        super(driver);
//    }


//    public AddNewTaskToListPage clickAddNewTaskBtn() throws InterruptedException {
//        //click add new task to list button
//
////        Thread.sleep(3000);
//        listWebElement.findElement(By.linkText(addTaskButtonText)).click();
//
//        //return new page object
//        return new AddNewTaskToListPage(driver);
//    }
}
