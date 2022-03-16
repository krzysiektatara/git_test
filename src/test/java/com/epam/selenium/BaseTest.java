package com.epam.selenium;

import com.epam.selenium.factory.WebDriverFactory;
import com.epam.selenium.pageobject.module.ProfileDropDownModule;
import com.epam.selenium.pageobject.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;
import static com.epam.selenium.properties.Properties.GIT_HUB_PASS;

public abstract class BaseTest {
    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

    public ProfileDropDownModule getProfileDropDownModule(LoginPage loginPage) {
        return loginPage
                .open()
                .login(GIT_HUB_LOGIN, GIT_HUB_PASS)
                .openProfileDropDown();
    }

    @BeforeTest
    public void setUpDriver() {
        webDriver.manage().window().maximize();
    }


    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }
}
