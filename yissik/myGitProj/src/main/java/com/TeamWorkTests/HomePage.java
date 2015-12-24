package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    HomePageMenuBar menuBar;


    HomePage(WebDriver driver) {
        super(driver);
        menuBar = new HomePageMenuBar();
        PageFactory.initElements(driver, this);

        //check that we are on the home page
        if (!isElementFound(By.id("topNavBarNew"))) {
            throw new IllegalStateException("This is not the home page");
        }
    }

    public DashBoardPage navigateToDashboard() {
        //navigates to dashboard by default
        return new DashBoardPage(driver);
    }
}
