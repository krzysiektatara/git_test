package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.invoker.implementations.date.Month;
import com.epam.selenium.pageobject.page.LoginPage;
import com.epam.selenium.pageobject.page.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContributionsTest extends BaseTest {

    LoginPage loginPage = new LoginPage(webDriver);

    @Test
    public void contributionTest() {

        ProfilePage profilePage = getProfileDropDownModule(loginPage)
                .goToProfilePage().sumContributionTableElements().
                isContainerWithSelectedDateOfContributionActivityPresent().contributionActivityElements();


        Assert.assertEquals(profilePage.getSumOfContributionTableElements(), profilePage.getSumOfContributionActivityElements(),
                "Sum of contribution table elements are different to sum of contribution table elements for: " + new Month().getDate());
    }
}
