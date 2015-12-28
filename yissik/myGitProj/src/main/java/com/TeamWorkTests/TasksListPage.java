package com.TeamWorkTests;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TasksListPage extends BasePage {

    List<WebElement> listWebElements;
    int numberOfTasksInTaskList;

    String listName;

    TasksListPage(String uniqueListName, WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.listName = uniqueListName;
    }

    public boolean findListByName() {
        try {
            listWebElements = driver.findElements(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
            return true;
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    public void findListByNameAndClickAddNewTaskButton() throws ElementNotFoundException {
        //click add new task to list button
        if(findListByName()) {
            WebElement addNewTaskBtn = listWebElements.get(0).findElement(By.xpath("*//button"));
            addNewTaskBtn.click();
        } else {
            throw new ElementNotFoundException("div", "class", "taskList");
        }
    }

    public void enterTaskName(String taskName) {
        listWebElements = driver.findElements(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
        WebElement enterTaskNameBox = listWebElements.get(0).findElement(By.xpath("*//input[@type='text' and @class='tt-query']"));
        enterTaskNameBox.sendKeys(taskName);
    }

    public void selectAssignTo(String userToAssignTo) {
        listWebElements = driver.findElements(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
//        WebElement enterTaskNameBox = listWebElements.findElement(By.xpath("*//input[@type='text' and @class='tt-query']"));
//        enterTaskNameBox.sendKeys(taskName);
        Select assignToDropdown = new Select(listWebElements.get(0).findElement(By.name("taskAssignedToUserId")));
        assignToDropdown.selectByVisibleText(userToAssignTo + " " + userToAssignTo);
    }

    public void clickSaveChangesToTaskBtn() {
        listWebElements = driver.findElements(By.xpath("//a[contains(text(), '" + listName + "')]/../.."));
        WebElement saveChangesToTaskBtn = listWebElements.get(0).findElement(By.xpath("*//input[@type='submit']"));
        saveChangesToTaskBtn.click();
        //vlidate task added
        //add to instance's list of taskslistWebElements
        addTaskToNumOfTasksInTaskList();
    }

    private void addTaskToNumOfTasksInTaskList() {
        numberOfTasksInTaskList++;
    }

    public int numOfTasks() {
        return numberOfTasksInTaskList;
    }


    public void deleteList() throws InterruptedException {
        if(findListByName()) {
            Thread.sleep(1000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", listWebElements.get(0));
            Thread.sleep(3000);
            WebElement parentElement = listWebElements.get(0);
            parentElement.findElement(By.xpath("*//a[contains(text(), '" + listName  + "')]")).click();


            driver.findElement(By.xpath("//i[@class='ico-project-options']")).click();
            String currentUrl = driver.getCurrentUrl();
            String[] splitCurrentUrl = currentUrl.split("\\/");
            currentUrl = splitCurrentUrl[splitCurrentUrl.length - 1];
            WebElement deleteButton = driver.findElement(By.xpath("//a[contains(@href, 'DeleteTaskList( " + currentUrl + "')]"));
            deleteButton.click();

        }
    }
}
