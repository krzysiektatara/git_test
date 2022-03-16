package com.epam.selenium.date;

import com.epam.selenium.properties.holder.PropertyHolder;
public class Year {
    PropertyHolder propertyHolder = new PropertyHolder();
    private final String year;

    public Year() {
        this.year = propertyHolder.readProperty("year");
    }

    public String getYear() {
        return this.year;
    }

}
