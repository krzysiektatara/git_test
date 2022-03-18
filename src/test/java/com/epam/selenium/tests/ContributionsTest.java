package com.epam.selenium.tests;

import com.epam.selenium.BaseTest;
import com.epam.selenium.invoker.implementations.date.Month;
import com.epam.selenium.pageobject.page.LoginPage;
import com.epam.selenium.pageobject.page.ProfilePage;
import com.epam.selenium.properties.holder.PropertyHolder;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContributionsTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage(webDriver);


    @Test
    public void contributionTest() {
        Month month = new Month(new PropertyHolder());
        final String monthName = month.getMonthName();
        final String monthNameCapitalized = StringUtils.capitalize(monthName.toLowerCase());

        ProfilePage profilePage = getProfileDropDownModule(loginPage)
                .goToProfilePage()
                .sumContributionTableElements()
                .scrollDownContributionActivity()
                .contributionActivityElements();


        Assert.assertEquals(profilePage.getSumOfContributionTableElements(), profilePage.getSumOfContributionActivityElements(),
                "Sum of contribution table elements are different to sum of contribution table elements for: " + month.getDate());
    }
}
