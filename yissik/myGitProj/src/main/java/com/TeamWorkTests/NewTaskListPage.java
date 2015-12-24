package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ninja on 24/12/15.
 */
public class NewTaskListPage extends BasePage {

    @FindBy(id = "newTaskListName")
    private WebElement newTaskListNameBox;

    @FindBy(id = "btnCreateTaskList")
    private WebElement addTaskListBtn;

    NewTaskListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterListName(String listName) {
        newTaskListNameBox.sendKeys(listName);
    }

    public TasksPage clickAddTaskList() {
        addTaskListBtn.click();
        return new TasksPage(driver);
    }
}
