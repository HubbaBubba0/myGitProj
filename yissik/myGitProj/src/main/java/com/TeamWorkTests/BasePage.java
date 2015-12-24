package com.TeamWorkTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    private List<WebElement> elements;

    BasePage(WebDriver driver) {
        this.driver = driver;
        elements = new LinkedList<WebElement>();
    }

    public boolean isElementFound(By by) {
        elements = driver.findElements(by);
        return !elements.isEmpty();
    }

}
