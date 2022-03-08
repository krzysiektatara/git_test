package com.epam.selenium.properties.holder;

import com.epam.selenium.properties.holder.exception.BrowserPropertiesNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHolder {
    private final Properties property = new Properties();

    {
        try (FileInputStream fis = new FileInputStream("src/test/resources/webdriver/browser.properties")) { //constructor
            property.load(fis);

        } catch (IOException e) {
            throw new BrowserPropertiesNotFoundException("can't find the property file", e);
        }
    }

    public String readProperty(String propertyName) {
        return property.getProperty(propertyName);
    }
}
