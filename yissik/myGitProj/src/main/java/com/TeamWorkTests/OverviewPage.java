package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends DashBoardPage {

    OverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        // Check that we're on the right page.
//        if (!"Login".equals(driver.getTitle())) {
//            // Alternatively, we could navigate to the login page, perhaps logging out first
//            throw new IllegalStateException("This is not the login page");
//        }
    }
}
