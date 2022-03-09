package com.epam.selenium.properties.conventor;

import com.epam.selenium.browser.SupportedBrowser;

import static com.epam.selenium.browser.SupportedBrowser.LOCAL_CHROME;
import static com.epam.selenium.browser.SupportedBrowser.LOCAL_FIREFOX;

public class SupportedBrowserConverter {
    public static SupportedBrowser valueOfWebBrowser(String webBrowserName) {
        return switch (webBrowserName) {
            case "local_chrome" -> LOCAL_CHROME;
            case "local_firefox" -> LOCAL_FIREFOX;
            default -> throw new IllegalArgumentException(String.format("%s is not supported", webBrowserName));//message with webbrowser name variable
        };
    }
}
