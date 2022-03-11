package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;
import static com.epam.selenium.properties.Properties.GIT_HUB_PASS;

public class ContributionsTest extends BaseTest {
    @Test
    public void contributionTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInformation = loginPage
                .open()
                .login(GIT_HUB_LOGIN, GIT_HUB_PASS)
                .openProfileDropDown()
                .goToProfilePage().smth();
        System.out.println(loginPage);
        Assert.assertEquals("2", userInformation, "nope");
    }
}
