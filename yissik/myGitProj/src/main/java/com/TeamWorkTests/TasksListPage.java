package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TasksListPage extends BasePage {

    WebElement listWebElement;

    String listName;

    TasksListPage(String uniqueListName, WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.listName = uniqueListName;
    }

    public void clickAddNewTaskBtn() {
        //click add new task to list button
        listWebElement = driver.findElement(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
//        String addTaskButtonText = "Add the first task";
        WebElement addNewTaskBtn = listWebElement.findElement(By.xpath("*//button"));
        addNewTaskBtn.click();
        //return new page object
//        return new AddNewTaskToListPage(driver);
    }

    public void enterTaskName(String taskName) {
        listWebElement = driver.findElement(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
        WebElement enterTaskNameBox = listWebElement.findElement(By.xpath("*//input[@type='text' and @class='tt-query']"));
        enterTaskNameBox.sendKeys(taskName);
    }

    public void selectAssignTo(String userToAssignTo) {
        listWebElement = driver.findElement(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
//        WebElement enterTaskNameBox = listWebElement.findElement(By.xpath("*//input[@type='text' and @class='tt-query']"));
//        enterTaskNameBox.sendKeys(taskName);
        Select assignToDropdown = new Select(listWebElement.findElement(By.name("taskAssignedToUserId")));
        assignToDropdown.selectByVisibleText(userToAssignTo + " " + userToAssignTo);
    }

    public void clickSaveChangesToTaskBtn() {
        listWebElement = driver.findElement(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
        WebElement saveChangesToTaskBtn = listWebElement.findElement(By.xpath("*//input[@type='submit']"));
        saveChangesToTaskBtn.click();
    }
}
