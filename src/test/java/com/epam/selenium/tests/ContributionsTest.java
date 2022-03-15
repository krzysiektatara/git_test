package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.pageobject.page.LoginPage;
import com.epam.selenium.pageobject.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

public class ContributionsTest extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void contributionTest() {

        ProfilePage profilePage = getProfileDropDownModule(loginPage)
                .goToProfilePage().getSumOfContributionTableElements().getListOfContributionTableElements();


Assert.assertEquals(profilePage.getSumOfElements1(), profilePage.getSumOfElements2(),"heh");
    }
}
