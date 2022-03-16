package com.epam.selenium.enums.browser;

import com.epam.selenium.invoker.WebDriverInvoker;
import com.epam.selenium.invoker.implementations.webDriver.LocalChromeInvoker;
import com.epam.selenium.invoker.implementations.webDriver.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowser {
    LOCAL_FIREFOX(new LocalFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker());

    private final WebDriverInvoker webDriverInvoker;

    SupportedBrowser(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}
