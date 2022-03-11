package com.epam.selenium.pageobject.page;

import com.epam.selenium.pageobject.BasePage;
import com.epam.selenium.pageobject.module.ProfileDropDownModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;

public class ProfilePage extends BasePage {
//    @FindBy(xpath = "//*[contains(@data-ga-click, 'Header, go to profile, text:your profile')]")
//    private WebElement yourProfile;
//@FindBy(xpath = "//*[name()=\"g\"]/*[name()=\"rect\"]")
    @FindBy(xpath = "//*[name()=\"g\"][last()]/*[name()=\"rect\"][4]")
    private WebElement contributionTableElement;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String smth() {
        return contributionTableElement.getAttribute("data-count");
    }
}
