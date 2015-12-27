package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ninja on 27/12/15.
 */
public class MilestonePage extends BasePage {

    @FindBy(xpath = "//button/span[@class='btn-addIcon']")
    WebElement addMilestoneBtn;

    WebElement milestoneElement;

    MilestonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddNewMilestonePage clickAddNewMileStoneBtn() throws InterruptedException {
        addMilestoneBtn.click();
        return new AddNewMilestonePage(driver);
    }

    public void hoverOverMilestone(String uniquemilestoneName) {
        Actions action = new Actions(driver);
        milestoneElement = driver.findElement(By.linkText(uniquemilestoneName));
        action.moveToElement(milestoneElement).perform();
    }

    public void attachMilestoneToTask(String uniquemilestoneName) {
        WebElement attachToTask = milestoneElement.findElement(By.xpath("*//a[contains(@id, '" + uniquemilestoneName + "')]"));
        attachToTask.click();
    }
}
