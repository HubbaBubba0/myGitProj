package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewTaskToListPage extends BasePage {

    public AddNewTaskToListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
