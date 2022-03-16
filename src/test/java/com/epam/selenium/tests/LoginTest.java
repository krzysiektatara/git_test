package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;
import static com.epam.selenium.properties.Properties.GIT_HUB_PASS;


public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void gitHubLoginTest() {
        String userInformation = loginPage
                .open()
                .login(GIT_HUB_LOGIN, GIT_HUB_PASS)
                .openProfileDropDown()
                .getUserInformationLabel();

        Assert.assertEquals("krzysiektatara", userInformation, "User nicks are nor equals");
    }
}
