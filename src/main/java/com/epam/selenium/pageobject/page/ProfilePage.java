package com.epam.selenium.pageobject.page;

import com.epam.selenium.date.Month;

import com.epam.selenium.pageobject.BasePage;

import com.epam.selenium.date.MonthToTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.OptionalInt;

public class ProfilePage extends BasePage {
    @FindBy(xpath = "//*[name()=\"g\"]/*[name()=\"rect\"]")
    private List<WebElement> contributionTableElements;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    final String month = new Month().getMonth();

    public int getSumOfContributionTableElements() {
        OptionalInt val = contributionTableElements.stream().
                filter(webElement -> webElement.getAttribute("data-date").startsWith(month)).
                mapToInt(c -> Integer.parseInt(c.getAttribute("data-count"))).
                reduce(Integer::sum);
        return val.orElse(0);
    }






}
