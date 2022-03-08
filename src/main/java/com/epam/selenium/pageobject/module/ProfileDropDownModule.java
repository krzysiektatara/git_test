package com.epam.selenium.pageobject.module;

import com.epam.selenium.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileDropDownModule extends BasePage {


    public ProfileDropDownModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserInformationLabel() {
        WebElement userInformationLabel = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\"krzysiektatara\"]"))); //create parameter foor username
        return userInformationLabel.getText();
    }
}
