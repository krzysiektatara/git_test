package com.epam.selenium.factory;

import com.epam.selenium.properties.holder.PropertyHolder;
import com.epam.selenium.properties.conventor.SupportedBrowserConverter;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    final PropertyHolder propertyHolder = new PropertyHolder();

    public WebDriver getWebDriver() {
        return SupportedBrowserConverter.valueOfWebBrowser(
                propertyHolder.readProperty("browser")).getWebDriver();
    }
}
