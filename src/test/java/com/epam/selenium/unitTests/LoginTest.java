package com.epam.selenium.unitTests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;
import static com.epam.selenium.properties.Properties.GIT_HUB_PASS;

public class LoginTest extends BaseTest {

    @Test
    public void gitHubLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInformation = loginPage
                .open()
                .login(GIT_HUB_LOGIN, GIT_HUB_PASS)
                .openProfileDropDown()
                .getUserInformationLabel();
        Assert.assertEquals(GIT_HUB_LOGIN, userInformation, "User nicks are not equals");
    }
}