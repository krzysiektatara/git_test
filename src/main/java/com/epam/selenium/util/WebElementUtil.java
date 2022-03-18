package com.epam.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class WebElementUtil {
    private WebElementUtil() {
    }

    public static boolean isPresent(String xPath, WebDriver webDriver) {
        try {
            return webDriver.findElement(By.xpath(xPath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
