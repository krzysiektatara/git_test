package com.epam.selenium.pageobject.module;

import com.epam.selenium.pageobject.BasePage;
import com.epam.selenium.pageobject.page.ProfilePage;
import com.epam.selenium.properties.holder.PropertyHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.selenium.properties.Properties.GIT_HUB_LOGIN;

public class ProfileDropDownModule extends BasePage {
    private final PropertyHolder propertyHolder = new PropertyHolder();
    private final String profileName = String.format("//strong[text()=\"%s\"]", GIT_HUB_LOGIN);

    @FindBy(xpath = "//*[contains(@data-ga-click, 'Header, go to profile, text:your profile')]")
    private WebElement yourProfile;

    public ProfileDropDownModule(WebDriver webDriver, PropertyHolder propertyHolder) {
        super(webDriver);
    }

    public String getUserInformationLabel() {
        WebElement userInformationLabel = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(profileName)));
        return userInformationLabel.getText();
    }

    public ProfilePage goToProfilePage() {
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(profileName)));
        yourProfile.click();
        return new ProfilePage(webDriver, propertyHolder);
    }
}
