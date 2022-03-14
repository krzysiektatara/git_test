package com.epam.selenium.pageobject.module;

import com.epam.selenium.pageobject.BasePage;
import com.epam.selenium.pageobject.page.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;

public class ProfileDropDownModule extends BasePage {
    @FindBy(xpath = "//*[contains(@data-ga-click, 'Header, go to profile, text:your profile')]")
    private WebElement yourProfile;

    private String profileName = String.format("//strong[text()=\"%s\"]", GIT_HUB_LOGIN);

    public ProfileDropDownModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserInformationLabel() {
        WebElement userInformationLabel = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profileName)));
        return userInformationLabel.getText();
    }

    public ProfilePage goToProfilePage() {
        WebElement userInformationLabel = new WebDriverWait(webDriver, 10).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath(profileName)));
        yourProfile.click();
        return new ProfilePage(webDriver);
    }

    public ContributionActivityModule goToContributionActivityModule() {
        WebElement userInformationLabel = new WebDriverWait(webDriver, 10).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath(profileName)));
        yourProfile.click();
        return new ContributionActivityModule(webDriver);
    }


}
