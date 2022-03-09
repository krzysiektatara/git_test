package com.epam.selenium.properties.holder;

import com.epam.selenium.properties.holder.exception.BrowserPropertiesNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHolder {
    private final Properties property = new Properties();

    public PropertyHolder() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/browser.properties")) {
            property.load(fis);
        } catch (IOException e) {
            throw new BrowserPropertiesNotFoundException("can't find the property file", e);
        }
    }

    //    InputStream fis = this.getClass().getResourceAsStream("/browser.properties");
//        try ( InputStream fis = this.getClass().getClassLoader().getResourceAsStream("resources/browser.properties")) {
    public String readProperty(String propertyName) {
        return property.getProperty(propertyName);
    }
}
