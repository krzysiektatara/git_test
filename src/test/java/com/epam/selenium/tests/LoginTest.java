package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void gitHubLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInformation = getProfileDropDownModule(loginPage).getUserInformationLabel();
        Assert.assertEquals(GIT_HUB_LOGIN, userInformation, "User nicks are not equals");
    }
}
