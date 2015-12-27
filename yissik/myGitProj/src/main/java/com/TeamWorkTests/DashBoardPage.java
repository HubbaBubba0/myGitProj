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
        //click the Tasks tab and return the newly tasks page
        return dashBoardMenu.navigateToTasksPage();
    }

    public MilestonePage navigateToMilestoneTab() throws InterruptedException {

        return dashBoardMenu.navigateToMilestonePage();
    }

//    public OverviewPage navigateToOverviewTab() {
//        return new OverviewPage(driver);
//    }
}
