package com.epam.selenium.pageobject.module;

import com.epam.selenium.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContributionActivityModule extends BasePage {
    protected ContributionActivityModule(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[contains(@id,'js-contribution-activity')]")
    private WebElement contributionActivityContainer;

    @FindBy(xpath = "//div[@class='contribution-activity-listing float-left col-12 '][.//span[contains(text(),'March')]]//div/preceding-sibling::summary[contains(@class,'btn-link f4 Link--muted no-underline lh-condensed width-full')]/span[1]")
    private List<WebElement> contributionActivityElements;

    public String getListOfContributionTableElements(){

       return contributionActivityElements.get(0).getText().replaceAll("[^\\d.]", "");


    }
}
