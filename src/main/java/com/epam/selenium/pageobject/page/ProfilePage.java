package com.epam.selenium.pageobject.page;

import com.epam.selenium.invoker.implementations.date.Month;
import com.epam.selenium.pageobject.BasePage;
import com.epam.selenium.properties.holder.PropertyHolder;
import com.epam.selenium.util.WebElementUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfilePage extends BasePage {

    private final static String MONTH_OF_ELEMENTS_X_PATH = "//span[contains(text(),\"%s\")]";
    private final Month month;
    private final String formattedDate;
    private final String monthName;
    private final String monthNameCapitalized;
    private final String contributionActivityElementsXPath;
    private List<WebElement> contributionActivityElements;
    private int sumOfContributionTableElements;
    private int sumOfContributionActivityElements;
    @FindBy(xpath = "//*[name()=\"g\"]/*[name()=\"rect\"]")
    private List<WebElement> contributionTableWebElements;
    @FindBy(xpath = "//button[contains(text(),'Show more activity')]")
    private WebElement showMoreButton;

    public ProfilePage(WebDriver webDriver, PropertyHolder propertyHolder) {
        super(webDriver);
        this.month = new Month((propertyHolder));
        this.formattedDate = month.getMonth();
        this.monthName = month.getMonthName();
        this.monthNameCapitalized = StringUtils.capitalize(month.getMonthName().toLowerCase());
        this.contributionActivityElementsXPath = String.format
                ("//div[@class='contribution-activity-listing float-left col-12 '][.//span[contains(text(),\"%s\")]]" +
                        "//div/preceding-sibling::summary[contains(@class,'btn-link')]/span[1]", monthNameCapitalized);
    }
    //div[@class='contribution-activity-listing float-left col-12 '][.//span[contains(text(),"February")]]//div/preceding-sibling::summary[contains(@class,'btn-link')] and h4[contains(@class,"text-normal color")/span[1] and h4[contains(@class,"text-normal color")]
    public int getSumOfContributionTableElements() {
        return sumOfContributionTableElements;
    }

    public int getSumOfContributionActivityElements() {
        return sumOfContributionActivityElements;
    }

    public ProfilePage scrollDownContributionActivity() {
        int counter = 1000;

        while (!WebElementUtil.isPresent(String.format(MONTH_OF_ELEMENTS_X_PATH, monthNameCapitalized), webDriver) && counter > 0) {
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.elementToBeClickable(showMoreButton));
            showMoreButton.click();
            counter--;
        }
        return this;
    }


    public ProfilePage sumContributionTableElements() {
        System.out.println(formattedDate);
        sumOfContributionTableElements = contributionTableWebElements.stream().
                filter(webElement -> webElement.getAttribute("data-date").startsWith(formattedDate)).
                mapToInt(c -> Integer.parseInt(c.getAttribute("data-count"))).
                reduce(Integer::sum).orElse(0);
        return this;
    }


    public ProfilePage contributionActivityElements() {
        int matchCounter = 0;
        contributionActivityElements = webDriver.findElements(By.xpath(contributionActivityElementsXPath));
        System.out.println(contributionActivityElements.size());
        Pattern integerPattern = Pattern.compile("\\d+");
        for (WebElement webElement : contributionActivityElements) {
            Matcher matcher = integerPattern.matcher(webElement.getText());
            System.out.println("a");
            boolean isMatcherFound = matcher.find();
            if (isMatcherFound) {
                sumOfContributionActivityElements += Integer.parseInt(matcher.group());
            } else {
                sumOfContributionActivityElements++;
            }
        }
        return this;
    }


}
