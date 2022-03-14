package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.Visibility;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;
import static com.epam.selenium.properties.Properties.GIT_HUB_PASS;

public class ContributionsTest extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void contributionTest() {

//        int amountOfContributions = getProfileDropDownModule(loginPage)
//                .goToProfilePage().getSumOfContributionTableElements();
//        Assert.assertEquals(49, amountOfContributions, "nope");

String s = getProfileDropDownModule(loginPage).goToContributionActivityModule().getListOfContributionTableElements();
Assert.assertEquals("AA", s,"heh");
    }
}
