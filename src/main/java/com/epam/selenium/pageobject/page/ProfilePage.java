package com.epam.selenium.pageobject.page;

import com.epam.selenium.date.Month;
import com.epam.selenium.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfilePage extends BasePage {

    final String month = new Month().getMonth();
    final String monthName = new Month().getMonthName();
    final String monthNameCapitalized = monthName.charAt(0) + monthName.substring(1).toLowerCase();
    private final String monthOfElementsXPath = String.format
            ("//span[contains(text(),\"%s\")]", monthNameCapitalized);

    private final String contributionActivityElementsXPath = String.format
            ("//div[.//span[contains(text(),\"%s\")]]//div/preceding-sibling::summary[contains(@class,'btn-link')]/span[1]", monthNameCapitalized);

    private final List<WebElement> contributionActivityElements = webDriver.findElements(By.xpath(contributionActivityElementsXPath));

    @FindBy(xpath = "//*[name()=\"g\"]/*[name()=\"rect\"]")
    private List<WebElement> contributionTableWebElements;

    @FindBy(xpath = "//button[contains(text(),'Show more activity')]")
    private WebElement showMoreButton;

    int sumOfContributionTableElements = 0;
    int sumOfContributionActivityElements = 0;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getSumOfContributionTableElements() {
        return sumOfContributionTableElements;
    }

    public int getSumOfContributionActivityElements() {
        return sumOfContributionActivityElements;
    }


    public ProfilePage isContainerWithSelectedDateOfContributionActivityPresent() {
        List<WebElement> l;
        boolean isPresent = false;

        while (!isPresent) {
            l = webDriver.findElements(By.xpath(monthOfElementsXPath));
            if (l.size() == 0) {
                showMoreButton.click();
                webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            } else isPresent = true;
        }
        return new ProfilePage(webDriver);
    }


    public ProfilePage sumContributionTableElements() {

        sumOfContributionTableElements = contributionTableWebElements.stream().
                filter(webElement -> webElement.getAttribute("data-date").startsWith(month)).
                mapToInt(c -> Integer.parseInt(c.getAttribute("data-count"))).
                reduce(Integer::sum).orElse(0);
        return new ProfilePage(webDriver);
    }


    public ProfilePage contributionActivityElements() {
        Pattern integerPattern = Pattern.compile("\\d+");
        for (WebElement webElement : contributionActivityElements) {
            Matcher matcher = integerPattern.matcher(webElement.getText());
            while (matcher.find()) {
                sumOfContributionActivityElements += Integer.parseInt(matcher.group());
            }
        }
        return new ProfilePage(webDriver);
    }


}
