package com.epam.selenium.pageobject.page;

import com.epam.selenium.pageobject.BasePage;
import com.epam.selenium.pageobject.module.ProfileDropDownModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;

public class HomePage extends BasePage {
    @FindBy(xpath = "//summary[@class=\"Header-link\"]/img")
    private WebElement profileDropDownButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfileDropDownModule openProfileDropDown() {
        profileDropDownButton.click();
        return new ProfileDropDownModule(webDriver);
    }
}