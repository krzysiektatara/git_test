package com.epam.selenium;

import com.epam.selenium.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

    @BeforeTest
    public void setUpDriver() {
        webDriver.manage().window().maximize();
    }

    @AfterTest
    public void quit() {
        webDriver.quit();
    }
}
