package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends HomePage {
    DashBoardMenu dashBoardMenu;
    DashBoardSideBar dashBoardSideBar;

    DashBoardPage(WebDriver driver) {
        super(driver);
        dashBoardMenu = new DashBoardMenu(driver);
        dashBoardSideBar = new DashBoardSideBar();
        PageFactory.initElements(driver, this);
    }

    public TasksPage navigateToTasksPage() {
        //click the Tasks tab
        dashBoardMenu.navigateToTasksPage();

        //return new tasks page
        return new TasksPage(driver);
    }
}
