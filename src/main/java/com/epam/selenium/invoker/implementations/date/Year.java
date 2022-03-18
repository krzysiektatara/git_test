package com.epam.selenium.invoker.implementations.date;

import com.epam.selenium.properties.holder.PropertyHolder;

public class Year {
    private final String year;

    public Year(PropertyHolder propertyHolder) {
        this.year = propertyHolder.readProperty("year");
    }

    public String getYear() {
        return this.year;
    }

}
