package com.TeamWorkTests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardMenu extends BasePage {

    @FindBy(id = "tab_tasks")
    private WebElement tasksTab;
    @FindBy(id = "tab_milestones")
    private WebElement milestoneTab;

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

    public MilestonePage navigateToMilestonePage() throws InterruptedException {
        //click on the tasks menu button
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", milestoneTab);
        Thread.sleep(3000);
        milestoneTab.click();

        //return new TasksPage
        return new MilestonePage(driver);
    }
}
