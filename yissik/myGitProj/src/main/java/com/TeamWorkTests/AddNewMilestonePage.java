package com.TeamWorkTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ninja on 27/12/15.
 */
public class AddNewMilestonePage extends BasePage {

    @FindBy(id = "milestoneName")
    WebElement milestoneNameBox;

    public AddNewMilestonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MilestonePage enterMilestoneNameAndSubmit(String milestoneName) {
        milestoneNameBox.sendKeys(milestoneName);
        return submitNewMilestone();
    }

    public MilestonePage submitNewMilestone() {
        milestoneNameBox.submit();
        return new MilestonePage(driver);
    }
}
