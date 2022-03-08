package com.epam.selenium.uitests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;
import static com.epam.selenium.properties.Properties.GIT_HUB_PASS;

public class LoginTest extends BaseTest {

//    @AfterTest
//    public void tearDown() {
//        quit();
//    }

    @Test
    public void gitHubLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInformation = loginPage
                .open()
                .login(GIT_HUB_LOGIN, GIT_HUB_PASS)
                        .openProfileDropDown()
                                .getUserInformationLabel();

        Assert.assertEquals("krzysiektatara", userInformation, "User nicks are nor equals");
    }
}
