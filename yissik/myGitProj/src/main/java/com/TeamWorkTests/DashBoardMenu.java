package com.TeamWorkTests;


import com.SugarCrm.PODdriver.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardMenu extends BasePage {

    @FindBy(id = "tab_tasks")
    private WebElement tasksTab;

    DashBoardMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TasksPage navigateToTasksPage() {
        //click on the tasks menu button
        tasksTab.click();

        //return new TasksPage
        return new TasksPage(driver);
    }
}
