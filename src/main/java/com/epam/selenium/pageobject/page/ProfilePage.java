package com.epam.selenium.pageobject.page;

import com.epam.selenium.pageobject.BasePage;

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

    public int createListOfContributionTableElements() {
        OptionalInt val = contributionTableElements.stream().
                filter(webElement -> webElement.getAttribute("data-date").startsWith("2022-02")).
                mapToInt(c -> Integer.parseInt(c.getAttribute("data-count"))).
                reduce(Integer::sum);
        return val.getAsInt();
    }






}
