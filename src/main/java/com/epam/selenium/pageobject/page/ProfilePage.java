package com.epam.selenium.pageobject.page;

import com.epam.selenium.date.Month;
import com.epam.selenium.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;

public class ProfilePage extends BasePage {

    final String month = new Month().getMonth();
    final String monthName = new Month().getMonthName();
    final String monthNameCapitalized = monthName.substring(0, 1) + monthName.substring(1).toLowerCase();

    int sumOfElements1 = 0;
    int sumOfElements2 = 0;

    @FindBy(xpath = "//*[name()=\"g\"]/*[name()=\"rect\"]")
    private List<WebElement> contributionTableElements;

    @FindBy(xpath = "//button[contains(text(),'Show more activity')]")
    private WebElement showMoreButton;

    private String monthOfElementsXPath =String.format("//span[contains(text(),\"%s\")]", monthNameCapitalized);
    private WebElement monthOfElements = webDriver.findElement(By.xpath(monthOfElementsXPath));



    private String contributionActivityElementsXPath = String.format("//div[.//span[contains(text(),\"%s\")]]//div/preceding-sibling::summary[contains(@class,'btn-link')]/span[1]", monthNameCapitalized);
    private List<WebElement> contributionActivityElements = webDriver.findElements(By.xpath(contributionActivityElementsXPath));

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getSumOfElements1() {
        return sumOfElements1;
    }

    public int getSumOfElements2() {
        return sumOfElements2;
    }

    public ProfilePage getSumOfContributionTableElements() {
int montCounter = 0;

/////////////////
        while (monthOfElements.getSize() != null || montCounter>=12){
            showMoreButton.click();
        }
        sumOfElements1 = contributionTableElements.stream().
                filter(webElement -> webElement.getAttribute("data-date").startsWith(month)).
                mapToInt(c -> Integer.parseInt(c.getAttribute("data-count"))).
                reduce(Integer::sum).orElse(0);
        return new ProfilePage(webDriver);
    }

    public ProfilePage getListOfContributionTableElements() {
        Pattern integerPattern = Pattern.compile("\\d+");
        for (WebElement webElement : contributionActivityElements) {
            Matcher matcher = integerPattern.matcher(webElement.getText());
            while (matcher.find()) {
                sumOfElements2 += Integer.parseInt(matcher.group());
            }
        }
        return new ProfilePage(webDriver);
    }


}
